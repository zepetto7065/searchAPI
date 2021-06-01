package com.sendBox.searchVideoAPI.search.controller;

import com.sendBox.searchVideoAPI.search.dao.SearchDao;
import com.sendBox.searchVideoAPI.search.domain.RequestDTO;
import com.sendBox.searchVideoAPI.search.domain.Video;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchControllerTest {

    @Autowired
    private SearchDao searchDao;

    private MockMvc mvc;

    @Test
    public void item이_리턴() throws Exception {
        //given
        String title = "광주";
        String ascYn = "Y";
        RequestDTO requestDTO = new RequestDTO(null, title, null, null, ascYn);
        //when
        List<Video> videos = searchDao.selectItemsById(requestDTO);
        //then
        assertThat(videos.size()).isGreaterThan(0);
    }


}