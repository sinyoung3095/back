package com.example.rebound.service;

import com.example.rebound.dto.PostCriteriaDTO;
import com.example.rebound.dto.PostDTO;

import java.util.List;

public interface PostService {

//    목록
    public PostCriteriaDTO getList(int page);
}
