package com.example.rebound.service;

import com.example.rebound.dto.CommentCriteriaDTO;
import com.example.rebound.dto.CommentDTO;
import com.example.rebound.dto.PostCriteriaDTO;
import com.example.rebound.dto.PostDTO;
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
    @Override
    public void write(CommentDTO commentDTO) {
        commentDAO.save(toCommentVO(commentDTO));
    }

    @Override
    public List<CommentDTO> getComments(Long postId) {
        return commentDAO.findAll(postId);
    }

//    @Override
//    public CommentCriteriaDTO findCommentsCriteria(int page) {
//        CommentCriteriaDTO commentCriteriaDTO = new CommentCriteriaDTO();
//        PostCriteria postCriteria = new PostCriteria(page, commentDAO.getCommentCountByPostId());
//        List<PostDTO> posts = commentDAO.findAll(postCriteria);
//        posts.forEach((post) -> {
//            post.setRelativeDate(PostDateUtils.toRelativeTime(post.getCreatedDate()));
//        });
//
//        postCriteria.setHasMore(posts.size() > postCriteria.getRowCount());
//
//        if(postCriteria.isHasMore()){
//            posts.remove(posts.size() - 1);
//        }
//
//        commentCriteriaDTO.setComments(comments);
//        commentCriteriaDTO.setPostCriteria(postCriteria);
//        return commentCriteriaDTO;
//    }
}
