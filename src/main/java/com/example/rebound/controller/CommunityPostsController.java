package com.example.rebound.controller;

import com.example.rebound.dto.PostCriteriaDTO;
import com.example.rebound.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts/**")
@RequiredArgsConstructor
public class CommunityPostsController {
    private final PostService postService;

//    목록
    @GetMapping("{page}")
    public PostCriteriaDTO list(@PathVariable("page") int page) {
        PostCriteriaDTO postCriteriaDTO = postService.getList(page);
        return postCriteriaDTO;
    }
}
