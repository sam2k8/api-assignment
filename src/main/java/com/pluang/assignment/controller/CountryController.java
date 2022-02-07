package com.pluang.assignment.controller;

import com.pluang.assignment.entity.Country;
import com.pluang.assignment.entity.CountryItem;
import com.pluang.assignment.entity.Item;
import com.pluang.assignment.entity.Search;
import com.pluang.assignment.service.CountryService;
import com.pluang.assignment.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @PostMapping("/details")
    public List<Country> getResult(@RequestBody CountryItem country){
        return countryService.getCountryDetails(country.getCountryName());
    }
}
