package com.sendBox.searchVideoAPI.search.mapper;

import com.sendBox.searchVideoAPI.search.domain.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SearchMapper {
    @Insert("INSERT INTO VIDEO\n" +
            "        (VIDEO_ID,TITLE,THUMBNAIL,PUBLISHED_AT)\n" +
            "        VALUES ( #{video_id}, #{title} ,#{thumbnail} ,#{published_at})")
    void insertData(Video video);
}

