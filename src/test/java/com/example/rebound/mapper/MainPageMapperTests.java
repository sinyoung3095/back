package com.example.rebound.mapper;

import com.example.rebound.dto.PostCriteriaDTO;
import com.example.rebound.util.PostCriteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MainPageMapperTests {
    @Autowired
    private MainPageMapper mainpageMapper;

//    게시글 목록 미리보기
    @Test
    public void testPostPreview(){
        log.info(mainpageMapper.postPreview().toString());
    }

//    오늘의 좋은 말 미리보기
    @Test
    public void testTodayMessagePreview(){
        log.info(mainpageMapper.todayMessagePreview().toString());
    }

//    공지사항 미리보기
    @Test
    public void testNoticePreview(){
        log.info(mainpageMapper.noticePreview().toString());
    }

//    전체 개수 조회(검색)
    @Test
    public void testSelectCountAllSearchMainPage(String keyword){
        log.info("{}", mainpageMapper.selectCountAllSearchMainPage(keyword));
    }

//   검색
    @Test
    public void testSelectPostFromMainPage(PostCriteriaDTO postCriteriaDTO, String keyword) {
        log.info(mainpageMapper.selectPostFromMainPage(postCriteriaDTO, keyword).toString());
    }

}
