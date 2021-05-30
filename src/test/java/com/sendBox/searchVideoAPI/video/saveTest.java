package com.sendBox.searchVideoAPI.video;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendBox.searchVideoAPI.search.domain.Video;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class saveTest {

    @Test
    public void jsonTest() throws IOException {
//        Properties properties = new Properties();
//        properties.load(new FileInputStream("src/main/resources/json/_video_list.json"));
        byte[] jsonStr = Files.readAllBytes(Paths.get("src/main/resources/json/_video_list.json"));
        String data = new String(jsonStr);
        System.out.println(data);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Video> listCar = objectMapper.readValue(data, new TypeReference<List<Video>>() {
        });
//        for (Video video : listCar) {
//            //System.out.println("video.toString() = " + video.toString());
//        }
    }
}
