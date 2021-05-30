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

    @Select("SELECT VIDEO_ID, TITLE, THUMBNAIL, PUBLISHED_AT FROM VIDEO" +
            " WHERE 1=1" +
            " <if test=\"title != null and title != '' \" > AND TITLE = #{title} </if>" +
            " <if test=\"startDate != null and startDate != '' \" > AND #{startDate} < TO_CHAR(PUBLISHED_AT, 'YYYYMMDD%') </if>" +
            " <if test=\"endDate != null and endDate != '' \" > AND #{endDate} > TO_CHAR(PUBLISHED_AT, 'YYYYMMDD%')  </if>" +
            " <if test=\"ascYn eq 'Y' \">ORDER BY PUBLISHED_AT ASC </if>" +
            " <if test=\"ascYn eq 'N' \">ORDER BY PUBLISHED_AT DESC </if>")
    List<Video> findItemsById(RequestDTO dto);
}

