package com.sendBox.searchVideoAPI.search.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
//@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
    private String video_id;
    private String title;
    private String startDate;
    private String endDate;
    private String ascYn;

    @Builder
    public RequestDTO(String video_id, String title, String startDate, String endDate, String ascYn) {
        this.video_id = video_id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ascYn = ascYn;
    }

    public void setStartDate(String replace) {
    }

    public void setEndDate(String replace) {
    }
}
