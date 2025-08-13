package com.example.rebound.repository;

import com.example.rebound.dto.PostDTO;
import com.example.rebound.mapper.PostMapper;
import com.example.rebound.util.PostCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private PostMapper postMapper;

//    게시글 목록
    public List<PostDTO> findAll(PostCriteria postCriteria) {
        return postMapper.selectAll(postCriteria);
    }

//    게시글 전체 갯수 조회
    public int findCountAll(){
        return postMapper.selectCountAll();
    }
}
