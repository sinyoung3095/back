package com.example.rebound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community-list/**")
public class CommunityController {
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
    @GetMapping("community-posts")
    public String goToCommunityList() {
        return "/community-list/community-posts";
    }

//    게시글(실패 경험담) 작성 페이지 이동
    @GetMapping("failure-write")
    public String goToFailureWrite() {
        return "/community-list/failure-write";
    }
}
