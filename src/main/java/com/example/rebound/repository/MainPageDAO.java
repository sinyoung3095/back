package com.example.rebound.repository;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.PostDTO;
import com.example.rebound.dto.TodayMessageDTO;
import com.example.rebound.mapper.MainPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MainPageDAO {
    public final MainPageMapper mainpageMapper;

//    게시글 목록 미리보기
    public List<PostDTO> postPreview () {
        return mainpageMapper.postPreview();
    }

//    상담사 소개
    public List<CounselorDTO> counselorIntroduction () {
        return mainpageMapper.counselorIntroduction();
    }

//    오늘의 좋은 말 미리보기
    public List<TodayMessageDTO> todayMessagePreview () {
        return mainpageMapper.todayMessagePreview();
    }
}
