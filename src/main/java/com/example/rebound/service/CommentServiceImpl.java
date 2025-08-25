package com.example.rebound.service;

import com.example.rebound.dto.CommentCriteriaDTO;
import com.example.rebound.dto.CommentDTO;
import com.example.rebound.repository.CommentDAO;
import com.example.rebound.repository.LikeDAO;
import com.example.rebound.util.PostCriteria;
import com.example.rebound.util.PostDateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDAO commentDAO;
    private final LikeDAO likeDAO;

//    댓글 작성
    @Override
    public void write(CommentDTO commentDTO) {
        commentDAO.save(toCommentVO(commentDTO));
    }

//    댓글 조회
    @Override
    public CommentCriteriaDTO getComments(Long postId, int page) {
        CommentCriteriaDTO commentCriteriaDTO = new CommentCriteriaDTO();
        PostCriteria criteria = new PostCriteria(page, commentDAO.getCommentsCountByPostId(postId));

        System.out.println("postId = " + postId);
        List<CommentDTO> comments = commentDAO.findAll(postId, criteria);
        System.out.println("comments = " + comments);

        comments.forEach((comment) -> {
            comment.setRelativeDate(PostDateUtils.toRelativeTime(comment.getCreatedDate()));
            comment.setLikesCount(likeDAO.getLikeCount(comment.getId()));
        });

        criteria.setHasMore(comments.size() > criteria.getRowCount());

        if(criteria.isHasMore()){
            comments.remove(comments.size() - 1);
        }

        commentCriteriaDTO.setComments(comments);
        commentCriteriaDTO.setCriteria(criteria);
        return commentCriteriaDTO;
    }

    @Override
    public void update(CommentDTO commentDTO) {
        commentDAO.update(toCommentVO(commentDTO));
    }

    @Override
    public void delete(Long id) {
        commentDAO.delete(id);
    }
}


