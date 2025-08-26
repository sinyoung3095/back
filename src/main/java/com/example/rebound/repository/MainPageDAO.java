package com.example.rebound.repository;

import com.example.rebound.dto.*;
import com.example.rebound.mapper.MainPageMapper;
import com.example.rebound.util.PostCriteria;
import com.example.rebound.util.Search;
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

//    오늘의 좋은 말 미리보기
    public List<TodayMessageDTO> todayMessagePreview () {
        return mainpageMapper.todayMessagePreview();
    }

//    공지사항 미리보기
    public List<NoticeDTO> noticePreview () {
        return mainpageMapper.noticePreview();
    }

}
