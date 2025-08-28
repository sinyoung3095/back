package com.example.rebound.mapper;

import com.example.rebound.dto.CommentAlarmDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CommentTest {
    @Autowired
    CommentMapper commentMapper;

    @Test
    public void testInsertCommentAlarm(){
        CommentAlarmDTO commentAlarmDTO = new CommentAlarmDTO();
        commentAlarmDTO.setMemberId(1L);
        commentAlarmDTO.setCommentId(1L);
        commentMapper.insertCommentAlarm(commentAlarmDTO);
    }
}
