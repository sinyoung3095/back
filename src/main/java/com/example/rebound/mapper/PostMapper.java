package com.example.rebound.mapper;

import com.example.rebound.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PostMapper {
//    목록
    public List<PostDTO> selectTitleAndContents();

}
