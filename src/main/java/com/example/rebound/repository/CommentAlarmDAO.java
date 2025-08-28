package com.example.rebound.repository;

import com.example.rebound.dto.CommentAlarmDTO;
import com.example.rebound.dto.CommentDTO;
import com.example.rebound.mapper.CommentAlarmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentAlarmDAO {
    private final CommentAlarmMapper commentAlarmMapper;

}
