package com.sendBox.searchVideoAPI.search.dao;

import com.sendBox.searchVideoAPI.search.domain.RequestDTO;
import com.sendBox.searchVideoAPI.search.domain.Video;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchDao {
    private final SqlSession sqlSession;

    public SearchDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Video selectItemById(String id) {
        return this.sqlSession.selectOne("selectItemById", id);
    }

    public List<Video> selectItemsById(RequestDTO dto) {
        return this.sqlSession.selectList("selectItemsById", dto);
    }
}
