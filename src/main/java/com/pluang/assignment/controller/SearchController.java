package com.pluang.assignment.controller;


import com.pluang.assignment.entity.Item;
import com.pluang.assignment.entity.Search;
import com.pluang.assignment.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @PostMapping("/")
    public Search getResult(@RequestBody Item item){
        return searchService.getSearchResult(item);
    }

}
