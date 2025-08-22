package com.example.rebound.service;

import com.example.rebound.dto.PostCriteriaDTO;
import com.example.rebound.dto.PostDTO;
import com.example.rebound.repository.CommentDAO;
import com.example.rebound.repository.PostDAO;
import com.example.rebound.util.PostCriteria;
import com.example.rebound.util.PostDateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommunityListServiceImpl implements CommunityListService {
    private final PostDAO postDAO;
    private final CommentDAO commentDAO;

    //    추가
    @Override
    public Long write(PostDTO postDTO) {
        return postDAO.save(postDTO);
    }

    //    조회수, 댓글 수 증가
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<PostDTO> getPost(Long id) {
        postDAO.updatePostReadCount(id);
        Optional<PostDTO> foundPost = postDAO.findPostWriterById(id);

        foundPost.ifPresent(post -> {
            post.setCommentCount(commentDAO.getCommentsCountByPostId(post.getId()));
        });

        return foundPost;
    }

    @Override
    public PostCriteriaDTO findPostsCriteria(int page) {
        PostCriteriaDTO postCriteriaDTO = new PostCriteriaDTO();
        PostCriteria postCriteria = new PostCriteria(page, postDAO.findCountAll());
        List<PostDTO> posts = postDAO.findAll(postCriteria);
        posts.forEach((post) -> {
            post.setRelativeDate(PostDateUtils.toRelativeTime(post.getCreatedDate()));
            post.setCommentCount(commentDAO.getCommentsCountByPostId(post.getId()));
        });

        postCriteria.setHasMore(posts.size() > postCriteria.getRowCount());

        if(postCriteria.isHasMore()){
            posts.remove(posts.size() - 1);
        }

        postCriteriaDTO.setPosts(posts);
        postCriteriaDTO.setPostCriteria(postCriteria);
        return postCriteriaDTO;
    }

//    수정
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePost(PostDTO postDTO) {
        postDAO.updatePost(postDTO);
    }

//    조회 수 기준 정렬
    @Override
    public List<PostDTO> getPostsByViews() {
        List<PostDTO> posts = postDAO.findByViews();
        posts.forEach(post -> {
            post.setRelativeDate(PostDateUtils.toRelativeTime(post.getCreatedDate()));
            post.setCommentCount(commentDAO.getCommentsCountByPostId(post.getId()));
        });
        return posts;
    }
}