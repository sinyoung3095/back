package com.example.rebound.mapper;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.NoticeDTO;
import com.example.rebound.dto.PostDTO;
import com.example.rebound.dto.TodayMessageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MainPageMapper {

//    게시글 목록 미리보기
    public List<PostDTO> postPreview ();

//    오늘의 좋은 말 미리보기
    public List<TodayMessageDTO> todayMessagePreview ();

//    공지사항 미리보기
    public List<NoticeDTO> noticePreview ();
}
