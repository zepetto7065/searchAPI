package com.sendBox.searchVideoAPI.search.domain;

import lombok.Getter;

@Getter
public class RequestDTO {
    private String video_id;
    private String title;
    private String startDate;
    private String endDate;
    private String ascYn;

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
