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
    public ResponseDTO getManyItems(String video_id, String title, String startDate, String endDate, String ascYn) {
        RequestDTO dto = new RequestDTO();
        if (null != video_id) dto.setVideo_id(video_id);
        if (null != title) dto.setTitle(title);
        if (null != startDate) dto.setStartDate(startDate);
        if (null != endDate) dto.setEndDate(endDate);
        if (null != ascYn) dto.setAscYn(ascYn);
        return this.searchService.getManyItems(dto);
    }
}
