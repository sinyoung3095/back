package com.example.rebound.mapper;

import com.example.rebound.domain.LikeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeMapper {
//    댓글 추천
    public void insertLike(LikeVO likeVO);

//    추천 삭제
    public void deleteLike(@Param("commentId") Long commentId, @Param("memberId") Long memberId);

//    추천 갯수
    public int countByCommentId(Long commentId);

//    추천 여부 확인
    public boolean checkLiked(@Param("commentId") Long commentId, @Param("memberId") Long memberId);
}
