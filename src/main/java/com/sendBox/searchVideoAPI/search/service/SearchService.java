package com.sendBox.searchVideoAPI.search.service;

import com.sendBox.searchVideoAPI.search.domain.RequestDTO;
import com.sendBox.searchVideoAPI.search.domain.ResponseDTO;
import com.sendBox.searchVideoAPI.search.domain.Video;

import java.util.List;

public interface SearchService {
    void saveVideo(List<Video> videoList);

    ResponseDTO getSingleItem(String id);

    ResponseDTO getManyItems(RequestDTO dto);
}
