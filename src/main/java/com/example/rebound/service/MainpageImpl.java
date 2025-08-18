package com.example.rebound.service;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.PostCriteriaDTO;
import com.example.rebound.dto.PostDTO;
import com.example.rebound.repository.CounselorDAO;
import com.example.rebound.repository.PostDAO;
import com.example.rebound.util.PostCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainpageImpl implements MainpageService {
    private final PostDAO postDAO;
    private final CounselorDAO counselorDAO;
    private final PostDTO postDTO;
    private final PostCriteriaDTO postCriteriaDTO;

    //    게시글 목록
    @Override
    public List<PostDTO> getPostList(PostCriteria postCriteria) {
        return postDAO.findAll(postCriteria);
    }

//    상담사 목록
    @Override
    public List<CounselorDTO> getCounselors() {
        return counselorDAO.getCounselorLists();
    }
}
