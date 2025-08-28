package com.example.rebound.mapper;

import com.example.rebound.dto.CommentAlarmDTO;
import com.example.rebound.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentAlarmMapper {
//    알람 조회
    public List<CommentDTO> selectCommentAlarmById(Long id);
}
