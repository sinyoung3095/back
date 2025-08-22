package com.example.rebound.repository;

import com.example.rebound.domain.CommentVO;
import com.example.rebound.dto.CommentDTO;
import com.example.rebound.mapper.CommentMapper;
import com.example.rebound.util.PostCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentDAO {
    private final CommentMapper commentMapper;

//    추가
    public void save(CommentVO commentVO) {
        commentMapper.insertComment(commentVO);
    }

//    전제 조회
    public List<CommentDTO> findAll(Long postId, PostCriteria postCriteria) {
        return commentMapper.selectCommentsByPostId(postId, postCriteria);
    }

//    댓글 수
    public int getCommentsCountByPostId(Long postId) {
        return commentMapper.selectCommentsCountByPostId(postId);
    }
}
