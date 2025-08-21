package com.example.rebound.service;

import com.example.rebound.domain.CommentVO;
import com.example.rebound.dto.CommentCriteriaDTO;
import com.example.rebound.dto.CommentDTO;

import java.util.List;

public interface CommentService {
//    추가
    public void write(CommentDTO commentDTO);

//    전체 조회
    public List<CommentDTO> getComments(Long postId);

//    public CommentCriteriaDTO findCommentsCriteria(int page);

    default CommentVO toCommentVO(CommentDTO commentDTO) {
        return CommentVO.builder()
                .id(commentDTO.getId())
                .commentContent(commentDTO.getCommentContent())
                .memberId(commentDTO.getMemberId())
                .postId(commentDTO.getPostId())
                .createdDatetime(commentDTO.getCreatedDate())
                .updatedDatetime(commentDTO.getUpdatedDate())
                .build();
    }


}
