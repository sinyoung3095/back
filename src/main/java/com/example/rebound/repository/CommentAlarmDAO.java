package com.example.rebound.repository;

import com.example.rebound.dto.CommentAlarmDTO;
import com.example.rebound.mapper.CommentAlarmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentAlarmDAO {
    private final CommentAlarmMapper commentAlarmMapper;

    public CommentAlarmDTO getCommentAlarm(Long id) {
        return commentAlarmMapper.selectCommentAlarmById(id);
    }
}
