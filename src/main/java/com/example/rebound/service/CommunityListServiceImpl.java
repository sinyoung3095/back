package com.example.rebound.service;

import com.example.rebound.dto.PostCriteriaDTO;
import com.example.rebound.dto.PostDTO;
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

    //    추가
    @Override
    public Long write(PostDTO postDTO) {
        return postDAO.save(postDTO);
    }

    //    조회, 조회수 증가
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<PostDTO> getPost(Long id) {
        postDAO.updatePostReadCount(id);
        return postDAO.findPostWriterById(id);
    }

    @Override
    public PostCriteriaDTO findPostsCriteria(int page) {
        PostCriteriaDTO postCriteriaDTO = new PostCriteriaDTO();
        PostCriteria postCriteria = new PostCriteria(page, postDAO.findCountAll());
        List<PostDTO> posts = postDAO.findAll(postCriteria);
        posts.forEach((post) -> {
            post.setRelativeDate(PostDateUtils.toRelativeTime(post.getCreatedDate()));
        });

        postCriteria.setHasMore(posts.size() > postCriteria.getRowCount());

        if(postCriteria.isHasMore()){
            posts.remove(posts.size() - 1);
        }

        postCriteriaDTO.setPosts(posts);
        postCriteriaDTO.setPostCriteria(postCriteria);
        return postCriteriaDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePost(PostDTO postDTO) {
        postDAO.updatePost(postDTO);
    }

    @Override
    public List<PostDTO> getPostsByViews() {
        return postDAO.findByViews();
    }
}