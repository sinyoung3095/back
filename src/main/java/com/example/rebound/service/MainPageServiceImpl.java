package com.example.rebound.service;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.NoticeDTO;
import com.example.rebound.dto.PostDTO;
import com.example.rebound.dto.TodayMessageDTO;
import com.example.rebound.repository.MainPageDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainPageServiceImpl implements MainPageService {
    public final MainPageDAO mainpageDAO;

//    게시글 목록 미리보기
    @Override
    public List<PostDTO> postPreview () {
        return mainpageDAO.postPreview();
    }

//    오늘의 좋은 말 미리보기
    @Override
    public List<TodayMessageDTO> todayMessagePreview () {
        return mainpageDAO.todayMessagePreview();
    }

//    공지사항 미리보기
    @Override
    public List<NoticeDTO> noticePreview () {
        return mainpageDAO.noticePreview();
    }

}
