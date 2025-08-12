package com.example.rebound.mapper;

import com.example.rebound.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityPostMapper {

//    게시글(실패 경험담) 추가
    public void addFailureWrite(PostDTO postDTO);

//    게시글 목록

}
