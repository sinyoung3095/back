package com.example.rebound.mapper;

import com.example.rebound.domain.CommentAlarmVO;
import com.example.rebound.domain.CommentVO;
import com.example.rebound.dto.CommentAlarmDTO;
import com.example.rebound.dto.CommentDTO;
import com.example.rebound.dto.PostDTO;
import com.example.rebound.util.PostCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
//    추가
    public void insertComment(CommentDTO commentDTO);

//    댓글 알림 추가
    public void insertCommentAlarm(CommentAlarmDTO commentAlarmDTO);

//    전체 조회
    public List<CommentDTO> selectCommentsByPostId(@Param("postId") Long postId, @Param("criteria") PostCriteria criteria);

//    댓글 수
    public int selectCommentsByPostId(Long postId);
//    keyword로 조회
    public List<CommentDTO> selectAllByKeyword(String keyword);
//    keyword로 수 조회
    public int selectCountAllByKeyword(String keyword);
  
//    댓글 수 조회
    public int selectCommentsCountByPostId(Long postId);

//    수정
    public void updateComment(CommentVO commentVO);

//    삭제
    public void delete(Long id);

//    추천 수 증가
    public int increaseLikesCount(Long id);

//    추천 수 감소
    public int decreaseLikesCount(Long id);
}
