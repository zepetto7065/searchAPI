package com.sendBox.searchVideoAPI.search.domain;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDTO {
    private Video item;
    private List<Video> items;
}
