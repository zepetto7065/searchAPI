package com.sendBox.searchVideoAPI.search.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendBox.searchVideoAPI.search.domain.Video;
import com.sendBox.searchVideoAPI.search.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Component
public class JsonParser implements ApplicationRunner {

    @Autowired
    private SearchService searchService;

    public void saveJsonData() {
        try {
            //DB에 JSON 파일을 적재
            byte[] jsonStr = Files.readAllBytes(Paths.get("src/main/resources/json/_video_list.json"));
            String data = new String(jsonStr);
            ObjectMapper objectMapper = new ObjectMapper();
            List<Video> listVideo = objectMapper.readValue(data, new TypeReference<List<Video>>() {
            });
            searchService.saveVideo(listVideo);
        } catch (IOException e) {
            log.error("json parsing error  : {}", e.getMessage());
        } catch (Exception e) {
            log.error("Error while saving db  : {}", e.getMessage());
        }

    }

    @Override
    public void run(ApplicationArguments args) {
        saveJsonData();
    }
}
