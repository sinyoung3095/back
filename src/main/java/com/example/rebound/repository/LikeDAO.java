package com.example.rebound.repository;

import com.example.rebound.domain.LikeVO;
import com.example.rebound.mapper.LikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LikeDAO {
    private final LikeMapper likeMapper;

//    댓글 추천
    public void save(LikeVO likeVO) {
        likeMapper.insertLike(likeVO);
    }

    // 추천 삭제
    public void delete(Long commentId, Long memberId) {
        likeMapper.deleteLike(commentId, memberId);
    }

    // 추천 수 조회
    public int getLikeCount(Long commentId) {
        return likeMapper.countByCommentId(commentId);
    }

    // 추천 여부 확인
    public boolean isexist(Long commentId, Long memberId) {
        return likeMapper.checkLiked(commentId, memberId);
    }
    public int findLikeCount(Long memberId,String month) {
        return likeMapper.countByMemberId(memberId,month);
    }

}
