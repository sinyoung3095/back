package com.example.rebound.repository;

import com.example.rebound.dto.PostDTO;
import com.example.rebound.mapper.MainpageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MainpageDAO {
    private final MainpageMapper mainpageMapper;

//    목록
    public List<PostDTO> findTitleAndContent(){
        return mainpageMapper.selectTitleAndContents();
    }
}
