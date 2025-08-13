package com.example.rebound.controller;

import com.example.rebound.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community-list/**")
public class CommunityController {
    private final PostService postService;

    public CommunityController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("community-contents")
    public String goToCommunityContents() {
        return "/community-list/community-contents";
    }
    @GetMapping("community-contents-member")
    public String goToCommunityContentsMember() {
        return "/community-list/community-contents-member";
    }
    @GetMapping("community-contents-writer")
    public String goToCommunityContentsWriter() {
        return "/community-list/community-contents-writer";
    }

//    게시글(실패 경험담) 커뮤니티 이동
    @GetMapping("community-posts/{page}")
    public String communityPosts(@PathVariable int page, Model model) {
        model.addAttribute("postsCriteriaDTO", postService.getList(page));
        return "/community-list/community-posts";
    }

//    게시글(실패 경험담) 작성 페이지 이동
    @GetMapping("failure-write")
    public String goToFailureWrite() {
        return "/community-list/failure-write";
    }
}
