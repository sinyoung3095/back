package com.example.rebound.service;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.PostDTO;
import com.example.rebound.util.PostCriteria;

import java.util.List;

public interface MainpageService {
//    게시글 목록
    public List<PostDTO> getPostList(PostCriteria postCriteria);
//    상담사 목록
    public List<CounselorDTO> getCounselors();
}
