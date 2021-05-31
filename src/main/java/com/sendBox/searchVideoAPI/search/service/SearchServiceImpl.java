package com.sendBox.searchVideoAPI.search.service;

import com.sendBox.searchVideoAPI.search.Exception.BadRequestException;
import com.sendBox.searchVideoAPI.search.Exception.ItemNotFoundException;
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
            e.printStackTrace();
            log.error("DB 적재 중 오류 발생 ! : ", e.getMessage());
        }
        log.debug("data 적재 성공");
    }

    @Override
    public ResponseDTO getSingleItem(String id) {
        if (null == id) {
            log.error("필수 파라미터가 존재하지 않습니다.");
            throw new BadRequestException();
        }
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Video video = this.searchDao.selectItemById(id);
            responseDTO.setItem(video);
        } catch (Exception e) {
            log.error("단일 아이템 조회 실패 : ", e.getMessage());
            throw new ItemNotFoundException(id);
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO getManyItems(RequestDTO dto) {
        if (null == dto.getVideo_id()) {
            log.error("필수 파라미터가 존재하지 않습니다.");
            throw new BadRequestException();
        }
        ResponseDTO responseDTO = new ResponseDTO();
        List<Video> items;
        try {
            if (null != dto.getStartDate()) dto.setStartDate(dto.getStartDate().replace(".", ""));
            if (null != dto.getEndDate()) dto.setEndDate(dto.getEndDate().replace(".", ""));

            items = this.searchDao.selectItemsById(dto);
            responseDTO.setItems(items);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("다중 아이템 조회 실패 : ", e.getMessage());
            throw new ItemNotFoundException(dto.getVideo_id());
        }
        return responseDTO;
    }

}
