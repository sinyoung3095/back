package com.example.rebound.service;

import com.example.rebound.dto.PostCriteriaDTO;
import com.example.rebound.dto.PostDTO;

import java.util.List;
import java.util.Optional;

public interface CommunityListService {
//    추가
    public Long write(PostDTO postDTO);
//    조회
    public Optional<PostDTO> getPost(Long id);
//    목록
    public PostCriteriaDTO findPostsCriteria(int page);
//    수정
    public void updatePost(PostDTO postDTO);
//    조회 수 정렬
    public List<PostDTO> getPostsByViews();


}
