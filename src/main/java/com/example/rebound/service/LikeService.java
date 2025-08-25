package com.example.rebound.service;

import com.example.rebound.domain.LikeVO;
import com.example.rebound.dto.LikeDTO;

public interface LikeService {
//    댓글 추천
    public void like(LikeDTO likeDTO);

    default LikeVO toLikeVO(LikeDTO likeDTO) {
        return LikeVO.builder()
                .id(likeDTO.getId())
                .commentId(likeDTO.getCommentId())
                .memberId(likeDTO.getMemberId())
                .createdDate(likeDTO.getCreatedDate())
                .updatedDate(likeDTO.getUpdatedDate())
                .build();
    }
}
