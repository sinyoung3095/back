package com.example.rebound.service;

import com.example.rebound.domain.CommentAlarmVO;
import com.example.rebound.domain.CommentVO;
import com.example.rebound.dto.CommentAlarmDTO;
import com.example.rebound.dto.CommentCriteriaDTO;
import com.example.rebound.dto.CommentDTO;
import com.example.rebound.dto.PostCriteriaDTO;

import java.util.List;

public interface CommentService {
//    추가
    public void write(CommentDTO commentDTO);

//    전체 조회
    public CommentCriteriaDTO getComments(Long postId, int page);

//    수정
    public void update(CommentDTO commentDTO);

//    삭제
    public void delete(Long id);

    default CommentVO toCommentVO(CommentDTO commentDTO) {
        return CommentVO.builder()
                .id(commentDTO.getId())
                .commentContent(commentDTO.getCommentContent())
                .memberId(commentDTO.getMemberId())
                .postId(commentDTO.getPostId())
                .createdDate(commentDTO.getCreatedDate())
                .updatedDate(commentDTO.getUpdatedDate())
                .build();
    }


}
