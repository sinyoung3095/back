package com.example.rebound.mapper;

import com.example.rebound.dto.CommentAlarmDTO;
import com.example.rebound.dto.CommentDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CommentTest {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    private CommentAlarmMapper commentAlarmMapper;

    @Test
    public void testSelectCommentAlarmById(){
        CommentAlarmDTO commentAlarmDTO = new CommentAlarmDTO();
        log.info(commentAlarmMapper.selectCommentAlarmById(commentAlarmDTO.getId()).toString());
    }

//    @Test
//    public void testSelectCommentAlarmByMemberId(){
//        CommentAlarmDTO commentAlarmDTO = new CommentAlarmDTO();
//        CommentDTO commentDTO = new CommentDTO();
//        commentAlarmDTO.setMemberId(commentDTO.getId());
//        commentAlarmDTO.setCommentId(commentDTO.getMemberId());
//        commentMapper.insertCommentAlarm(commentAlarmDTO);
//    }



}
