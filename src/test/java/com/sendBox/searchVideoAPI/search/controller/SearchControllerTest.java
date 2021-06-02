package com.sendBox.searchVideoAPI.search.controller;

import com.sendBox.searchVideoAPI.search.dao.SearchDao;
import com.sendBox.searchVideoAPI.search.domain.RequestDTO;
import com.sendBox.searchVideoAPI.search.domain.ResponseDTO;
import com.sendBox.searchVideoAPI.search.domain.Video;
import com.sendBox.searchVideoAPI.search.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchControllerTest {
    @Autowired
    private SearchDao searchDao;

    @Autowired
    private SearchService searchService;

    @Test
    public void 단일검색Test() {
        //given
        String id = "2FWPrbadt_Y";
        //when
        ResponseDTO singleItem = searchService.getSingleItem(id);
        //then
        assertThat(singleItem).isNotNull();
    }

    @Test
    public void title_오름차순검색() {
        //given
        String title = "광주";
        String ascYn = "Y";
        RequestDTO requestDTO = RequestDTO.builder()
                .title(title)
                .video_id(null)
                .startDate(null)
                .endDate(null)
                .ascYn(ascYn)
                .build();        //when
        List<Video> videos = searchDao.selectItemsById(requestDTO);
        //then
        assertThat(videos.size()).isGreaterThan(0);
    }

    @Test
    public void title_내림차순검색() {
        //given
        String title = "닉변해요";
        String ascYn = "N";
        RequestDTO requestDTO = RequestDTO.builder()
                .title(title)
                .video_id(null)
                .startDate(null)
                .endDate(null)
                .ascYn(ascYn)
                .build();
        //when
        List<Video> videos = searchDao.selectItemsById(requestDTO);
        //then
        assertThat(videos.size()).isGreaterThan(0);
    }

}