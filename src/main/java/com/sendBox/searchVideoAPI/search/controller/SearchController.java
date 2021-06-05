package com.sendBox.searchVideoAPI.search.controller;

import com.sendBox.searchVideoAPI.search.domain.RequestDTO;
import com.sendBox.searchVideoAPI.search.domain.ResponseDTO;
import com.sendBox.searchVideoAPI.search.service.SearchService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;


    @GetMapping("/search/api/single/{id}")
    public ResponseDTO getSingleItem(@PathVariable String id) {
        return this.searchService.getSingleItem(id);
    }

    @PostMapping("/search/api/many")
    public ResponseDTO getManyItems(@RequestBody RequestDTO dto) {
        return this.searchService.getManyItems(dto);
    }
}
