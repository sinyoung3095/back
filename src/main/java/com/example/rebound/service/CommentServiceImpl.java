package com.example.rebound.service;

import com.example.rebound.dto.CommentCriteriaDTO;
import com.example.rebound.dto.CommentDTO;
import com.example.rebound.repository.CommentDAO;
import com.example.rebound.util.PostCriteria;
import com.example.rebound.util.PostDateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDAO commentDAO;

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

        List<CommentDTO> comments = commentDAO.findAll(postId, criteria);

        comments.forEach((reply) -> {
            reply.setRelativeDate(PostDateUtils.toRelativeTime(reply.getCreatedDate()));
        });

        criteria.setHasMore(comments.size() > criteria.getRowCount());

        if(criteria.isHasMore()){
            comments.remove(comments.size() - 1);
        }

        commentCriteriaDTO.setComments(comments);
        commentCriteriaDTO.setCriteria(criteria);
        return commentCriteriaDTO;
    }
}


