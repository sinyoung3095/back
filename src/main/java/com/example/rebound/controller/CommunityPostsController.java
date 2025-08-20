package com.example.rebound.controller;

import com.example.rebound.dto.PostCriteriaDTO;
import com.example.rebound.service.CommunityListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/community-posts/**")
@RequiredArgsConstructor
public class CommunityPostsController {
    private final CommunityListService communityPostService;

//    목록
    @GetMapping("{page}")
    public PostCriteriaDTO getPosts(@PathVariable("page") int page) {
        return communityPostService.findPostsCriteria(page);
    }
}
