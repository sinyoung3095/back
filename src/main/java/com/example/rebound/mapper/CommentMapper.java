package com.example.rebound.mapper;

import com.example.rebound.domain.CommentVO;
import com.example.rebound.dto.CommentDTO;
import com.example.rebound.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
//    추가
    public void insertComment(CommentVO commentVO);

//    전체 조회
    public List<CommentDTO> selectRepliesByPostId(Long postId);

//    댓글 수
    public int selectCommentsByPostId(Long postId);
//    keyword로 조회
    public List<CommentDTO> selectAllByKeyword(String keyword);
//    keyword로 수 조회
    public int selectCountAllByKeyword(String keyword);

}
