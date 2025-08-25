package com.example.rebound.service;

import com.example.rebound.domain.LikeVO;
import com.example.rebound.dto.LikeDTO;
import com.example.rebound.repository.CommentDAO;
import com.example.rebound.repository.LikeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeDAO likeDAO;
    private final CommentDAO commentDAO;

    @Override
    public void like(LikeDTO likeDTO) {
        LikeVO likeVO = toLikeVO(likeDTO);
        likeDAO.save(likeVO);
        commentDAO.increaseLikesCount(likeVO.getCommentId());
    }

    @Override
    public void removeLike(Long commentId, Long memberId) {
        likeDAO.delete(commentId, memberId);
        commentDAO.decreaseLikesCount(commentId);
    }

    @Override
    public int getLikeCount(Long commentId) {
        return likeDAO.getLikeCount(commentId);
    }

    @Override
    public boolean checkedLike(Long commentId, Long memberId) {
        return likeDAO.exists(commentId, memberId);
    }
}
