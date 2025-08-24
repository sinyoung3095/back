package com.example.rebound.repository;

import com.example.rebound.domain.CommentVO;
import com.example.rebound.dto.CommentDTO;
import com.example.rebound.dto.PostDTO;
import com.example.rebound.mapper.CommentMapper;
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
    public List<CommentDTO> findAll(Long postId) {
        return commentMapper.selectRepliesByPostId(postId);
    }

//    댓글 수
    public int getCommentCountByPostId(Long postId) {
        return commentMapper.selectCommentsByPostId(postId);
    }
//    keyword로 조회
    public List<CommentDTO> findAllByKeyword(String keyword) {
        return commentMapper.selectAllByKeyword(keyword);
    }
//    keyword로 조회
    public int findCountByKeyword(String keyword) {
        return commentMapper.selectCountAllByKeyword(keyword);
    }
}
