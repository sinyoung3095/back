package com.example.rebound.mapper;

import com.example.rebound.dto.*;
import com.example.rebound.util.PostCriteria;
import com.example.rebound.util.Search;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

//    전체 개수 조회(검색)
    public int selectCountAllSearchMainPage (String keyword);

//    검색
    public List<PostDTO> selectPostFromMainPage (@Param("postCriteria") PostCriteria postCriteria, @Param("keyword") String keyword);

}
