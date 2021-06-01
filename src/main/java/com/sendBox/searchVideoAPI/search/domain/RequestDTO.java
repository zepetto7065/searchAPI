package com.sendBox.searchVideoAPI.search.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
    private String video_id;
    private String title;
    private String startDate;
    private String endDate;
    private String ascYn;

    public void setStartDate(String replace) {
    }

    public void setEndDate(String replace) {
    }
}
