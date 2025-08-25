package com.example.rebound.repository;

import com.example.rebound.domain.LikeVO;
import com.example.rebound.mapper.LikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LikeDAO {
    private final LikeMapper likeMapper;
    public void save(LikeVO likeVO) {
        likeMapper.insertLike(likeVO);
    }
}
