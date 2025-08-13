package com.example.rebound.repository;

import com.example.rebound.dto.PostDTO;
import com.example.rebound.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

//    목록
    public List<PostDTO> findTitleAndContent(){
        return postMapper.selectTitleAndContents();
    }
}
