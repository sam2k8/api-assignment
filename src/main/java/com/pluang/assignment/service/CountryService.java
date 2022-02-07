package com.pluang.assignment.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pluang.assignment.entity.Country;
import com.pluang.assignment.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CountryService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${country_api_url}")
    private String countryBaseUrl;
    @Value("${fixer_api_url}")
    private String rateBaseUrl;
    @Value("${fixer_access_key}")
    private String rateAccessKey;

    public List<Country> getCountryDetails(String countryName) {

        List<Country> countryList=new ArrayList<>();

        String uri=countryBaseUrl.concat("name/").concat(countryName);

        ArrayNode countries = restTemplate.getForObject(uri,ArrayNode.class);

        countries.forEach( jsonNode -> {
            Country country= new Country();
            List<Currency> currency = new ArrayList<>();

            country.setName(jsonNode.get("name").get("official").asText());
            country.setPopulation(jsonNode.get("population").asLong());
            Iterator<String> it = jsonNode.get("currencies").fieldNames();
            while(it.hasNext()){
               String currencyName = it.next();
               Double currencyRate = getRates(currencyName);
               currency.add(new Currency(currencyName,currencyRate) );
            }
            country.setCurrencies(currency);
            countryList.add(country);
        });

        return countryList;
    }

    public double getRates( String currency){

        String uri = rateBaseUrl.concat("?access_key=").concat(rateAccessKey);
        ObjectNode currentRate = restTemplate.getForObject(uri,ObjectNode.class);
        return Double.valueOf(currentRate.get("rates").get(currency).asText());

    }
}
