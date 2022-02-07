package com.pluang.assignment.service;


import com.pluang.assignment.entity.Item;
import com.pluang.assignment.entity.Search;
import com.pluang.assignment.repository.SearchResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SearchService {

    @Autowired
    private SearchResultRepository searchResultRepository;

    public Search getSearchResult(Item item) {

        Search search = searchResultRepository.findBySearchItem(item.getSearchItem());

        Search emptySearch = new Search("false");
        Search searchResult = new Search();

        if(search == null){
            Search newSearch = new Search();
            newSearch.setResult("true");
            newSearch.setFirstInsertDateTime(LocalDateTime.now());
            newSearch.setLastSearchDateTime(null);
            newSearch.setSearchItem(item.getSearchItem());
            newSearch.setSearchCount(1);
            searchResultRepository.save(newSearch);
            searchResult = emptySearch;

        }else {

            searchResult.setSearchCount(search.getSearchCount());
            searchResult.setLastSearchDateTime(search.getLastSearchDateTime());
            searchResult.setFirstInsertDateTime(search.getFirstInsertDateTime());
            searchResult.setResult(search.getResult());

            //Updating Info
            search.setLastSearchDateTime(LocalDateTime.now());
            search.setSearchCount(search.getSearchCount() +1);
            searchResultRepository.save(search);
        }

        return searchResult;
    }
}
