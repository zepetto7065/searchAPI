package com.sendBox.searchVideoAPI.search.mapper;

import com.sendBox.searchVideoAPI.search.domain.RequestDTO;
import com.sendBox.searchVideoAPI.search.domain.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface SearchMapper {
    @Insert("INSERT INTO VIDEO\n" +
            "        (VIDEO_ID,TITLE,THUMBNAIL,PUBLISHED_AT)\n" +
            "        VALUES ( #{video_id}, #{title} ,#{thumbnail} ,#{published_at})")
    void insertData(Video video);

    @Select("SELECT VIDEO_ID, TITLE, THUMBNAIL, PUBLISHED_AT FROM VIDEO WHERE VIDEO_ID = #{id}")
    Video findItemById(String id);

    @Select("SELECT VIDEO_ID, TITLE, THUMBNAIL, PUBLISHED_AT FROM VIDEO")
    List<Video> findItemsById(RequestDTO dto);
}

