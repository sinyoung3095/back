package com.example.rebound.service;


import com.example.rebound.dto.*;
import com.example.rebound.util.PostCriteria;

import java.util.List;
import java.util.Optional;

// 메인 페이지 서비스
public interface MainPageService {

//    게시글 목록 미리보기
    public List<PostDTO> postPreview ();

//    오늘의 좋은 말 미리보기
    public List<TodayMessageDTO> todayMessagePreview ();

//    공지사항 미리보기
    public List<NoticeDTO> noticePreview ();

//    검색(메인페이지 → 커뮤니티 목록)
    public List<PostDTO> selectPostFromMainPage (PostCriteriaDTO postCriteriaDTO);
}
