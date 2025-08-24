package com.example.rebound.mapper;

import com.example.rebound.domain.CommentVO;
import com.example.rebound.dto.CommentDTO;
import com.example.rebound.util.PostCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
//    추가
    public void insertComment(CommentVO commentVO);

//    전체 조회
    public List<CommentDTO> selectCommentsByPostId(@Param("postId") Long postId, @Param("criteria") PostCriteria criteria);

//    댓글 수 조회
    public int selectCommentsCountByPostId(Long postId);

//    수정
    public void updateComment(CommentVO commentVO);

//    삭제
    public void delete(Long id);
}
