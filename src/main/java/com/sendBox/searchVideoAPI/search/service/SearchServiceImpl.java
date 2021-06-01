package com.sendBox.searchVideoAPI.search.service;

import com.sendBox.searchVideoAPI.search.Exception.MaxListLengthException;
import com.sendBox.searchVideoAPI.search.Exception.RequestNotFoundException;
import com.sendBox.searchVideoAPI.search.dao.SearchDao;
import com.sendBox.searchVideoAPI.search.domain.RequestDTO;
import com.sendBox.searchVideoAPI.search.domain.ResponseDTO;
import com.sendBox.searchVideoAPI.search.domain.Video;
import com.sendBox.searchVideoAPI.search.mapper.SearchMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;
    @Autowired
    private SearchDao searchDao;

    @Override
    public void saveVideo(List<Video> videoList) {
        try {
            log.debug("data 적재 시작");
            for (Video video : videoList) {
                this.searchMapper.insertData(video);
            }
        } catch (Exception e) {
            log.error("Error while saving DB, Please Check your Error ::: {}", e.getMessage());
        }
        log.debug("data 적재 성공");
    }

    @Override
    public ResponseDTO getSingleItem(String id) {
        if (null == id) {
            throw new RequestNotFoundException();
        }
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Video video = this.searchDao.selectItemById(id);
            responseDTO.setItem(video);
        } catch (Exception e) {
            log.error("Could not find item , please check your id : {} , error ::: {}", id, e.getMessage());
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO getManyItems(RequestDTO dto) {
        ResponseDTO responseDTO = new ResponseDTO();
        List<Video> items;
        try {
            //날짜 format 변환
            if (null != dto.getStartDate()) dto.setStartDate(dto.getStartDate().replace(".", ""));
            if (null != dto.getEndDate()) dto.setEndDate(dto.getEndDate().replace(".", ""));

            items = this.searchDao.selectItemsById(dto);
            if (items.size() > 20) {
                throw new MaxListLengthException(items.size());
            }
            responseDTO.setItems(items);
        } catch (Exception e) {
            log.error("Could not find item , please check error ::: {}", e.getMessage());
        }
        return responseDTO;
    }

}
