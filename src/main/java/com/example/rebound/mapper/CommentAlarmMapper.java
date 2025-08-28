package com.example.rebound.mapper;

import com.example.rebound.dto.CommentAlarmDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentAlarmMapper {
//    알람 조회
    public CommentAlarmDTO selectCommentAlarmById(Long id);
}
