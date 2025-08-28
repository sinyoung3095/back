package com.example.rebound.service;

import com.example.rebound.dto.CommentDTO;

import java.util.List;

public interface CommentAlarmService {
    public List<CommentDTO> getComments(Long id);
}
