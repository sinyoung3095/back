package com.example.rebound.service;

import com.example.rebound.dto.CommentAlarmDTO;
import com.example.rebound.dto.CommentDTO;
import com.example.rebound.mapper.CommentAlarmMapper;
import com.example.rebound.repository.CommentAlarmDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentAlarmServiceImpl implements CommentAlarmService {
    public final CommentAlarmDAO commentAlarmDAO;

    public List<CommentDTO> getComments(Long id) {
        return commentAlarmDAO.getCommentAlarm(id);
    }
}
