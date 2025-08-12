package com.example.rebound.service;

import com.example.rebound.dto.PostCriteriaDTO;
import com.example.rebound.dto.PostDTO;
import com.example.rebound.repository.PostDAO;
import com.example.rebound.util.PostCriteria;
import com.example.rebound.util.PostDateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostDAO postDAO;

    @Override
    public PostCriteriaDTO getList(int page) {
        PostCriteriaDTO postCriteriaDTO = new PostCriteriaDTO();
        PostCriteria postCriteria = new PostCriteria(page, postDAO.findCountAll());
        List<PostDTO> posts = postDAO.findAll(postCriteria);
        posts.forEach((post) -> {
            post.setRelativeDate(PostDateUtils.toRelativeTime(post.getCreatedDate()));
        });

        postCriteria.setHasMore(posts.size() > postCriteria.getRowCount());

//        11개 가져왔으면, 마지막 1개 삭제
        if(postCriteria.isHasMore()){
            posts.remove(posts.size() - 1);
        }

        postCriteriaDTO.setPosts(posts);
        postCriteriaDTO.setPostCriteria(postCriteria);
        return postCriteriaDTO;
    }
}
