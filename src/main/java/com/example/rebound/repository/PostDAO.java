package com.example.rebound.repository;

import com.example.rebound.dto.PostDTO;
import com.example.rebound.mapper.CommunityListMapper;
import com.example.rebound.util.PostCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final CommunityListMapper communityListMapper;

//    추가
    public Long save(PostDTO postDTO) {
        communityListMapper.insertCommunityPost(postDTO);
        return postDTO.getId();
    }

//    조회
    public Optional<PostDTO> findPostWriterById(Long id) {
        return communityListMapper.selectCommunityPostWriter(id);
    }

//    조회수 증가
    public void updatePostReadCount(Long id) {
        communityListMapper.updatePostReadCount(id);
    }

//    목록
    public List<PostDTO> findAll(PostCriteria postCriteria){
        return communityListMapper.selectAll(postCriteria);
    }

//    전체 개수 조회
    public int findCountAll(){
        return communityListMapper.selectCountAll();
    }

//    수정
    public void updatePost(PostDTO postDTO) {
        communityListMapper.updateCommunityPost(postDTO);
    }

//    조회 수 정렬
    public List<PostDTO> findByViews() {
        return communityListMapper.selectAllByViews();
    }
}
