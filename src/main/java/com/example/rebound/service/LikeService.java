package com.example.rebound.service;

import com.example.rebound.domain.LikeVO;
import com.example.rebound.dto.LikeDTO;

public interface LikeService {
//    댓글 추천
    public void like(LikeDTO likeDTO);

//    추천 취소
    public void removeLike(Long commentId, Long memberId);

//    추천 갯수
    public int getLikeCount(Long commentId);

//    추천 여부 확인
    public boolean checkedLike(Long commentId, Long memberId);

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
