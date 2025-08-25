package com.example.rebound.mapper;

import com.example.rebound.domain.LikeVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {
//    댓글 추천
    public void insertLike(LikeVO likeVO);

}
