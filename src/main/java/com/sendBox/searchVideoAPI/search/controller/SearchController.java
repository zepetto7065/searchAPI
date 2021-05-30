package com.sendBox.searchVideoAPI.search.controller;

import com.sendBox.searchVideoAPI.search.domain.RequestDTO;
import com.sendBox.searchVideoAPI.search.domain.ResponseDTO;
import com.sendBox.searchVideoAPI.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search/api/single/{id}")
    public ResponseDTO getSingleItem(@PathVariable String id) {
        return this.searchService.getSingleItem(id);
    }

    @GetMapping("/search/api/many")
    public ResponseDTO getManyItems(RequestDTO dto) {
        return this.searchService.getManyItems(dto);
    }
}
