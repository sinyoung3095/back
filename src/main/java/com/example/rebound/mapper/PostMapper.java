package com.example.rebound.mapper;

import com.example.rebound.dto.PostDTO;
import com.example.rebound.util.PostCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

//    게시글 목록
    public List<PostDTO> selectAll(PostCriteria postCriteria);

//    게시글 전체 갯수
    public int selectCountAll();

}
