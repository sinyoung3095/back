package com.example.rebound.service;


import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.PostDTO;
import com.example.rebound.dto.TodayMessageDTO;

import java.util.List;
import java.util.Optional;

public interface MainPageService {

//    게시글 목록 미리보기
    public List<PostDTO> postPreview ();

//    상담사 소개
    public List<CounselorDTO> counselorIntroduction ();

//    오늘의 좋은 말 미리보기
    public List<TodayMessageDTO> todayMessagePreview ();
}
