package com.sendBox.searchVideoAPI.search.domain;

import lombok.Data;

@Data
public class RequestDTO {
    private String video_id;
    private String title;
    private String startDate;
    private String endDate;
    private String ascYn = "N";
}
