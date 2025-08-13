package com.example.rebound.service;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.PostDTO;
import com.example.rebound.repository.CounselorDAO;
import com.example.rebound.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainpageImpl implements MainpageService {
    private final PostDAO postDAO;
    private final CounselorDAO counselorDAO;

//    게시글 목록
    @Override
    public List<PostDTO> getLists() {
        return postDAO.findTitleAndContent();
    }

//    상담사 목록
    @Override
    public List<CounselorDTO> getCounselors() {
        return counselorDAO.getCounselorLists();
    }
}
