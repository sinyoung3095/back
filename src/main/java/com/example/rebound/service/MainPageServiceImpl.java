package com.example.rebound.service;

import com.example.rebound.dto.*;
import com.example.rebound.repository.MainPageDAO;
import com.example.rebound.repository.PostDAO;
import com.example.rebound.util.PostCriteria;
import com.example.rebound.util.PostDateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainPageServiceImpl implements MainPageService {
    public final MainPageDAO mainpageDAO;
    private final PostDAO postDAO;

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

//    검색
    @Override
    public PostCriteriaDTO selectPostFromMainPage (int page, String keyword) {
        PostCriteriaDTO postCriteriaDTO = new PostCriteriaDTO();
        PostCriteria postCriteria = new PostCriteria(page, mainpageDAO.selectCountAll(keyword));
        List<PostDTO> posts = mainpageDAO.selectPostFromMainPage(postCriteriaDTO, keyword);
        posts.forEach((post) -> {
            post.setRelativeDate(PostDateUtils.toRelativeTime(post.getCreatedDate()));
        });

        postCriteria.setHasMore(posts.size() > postCriteria.getRowCount());

//        11개 가져왔으면, 마지막 1개 삭제
        if(postCriteria.isHasMore()){
            posts.remove(posts.size() - 1);
        }

        postCriteriaDTO.setPosts(posts);
        postCriteriaDTO.setPostCriteria(postCriteria);
        return postCriteriaDTO;
    }
}
