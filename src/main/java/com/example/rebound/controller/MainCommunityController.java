package com.example.rebound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community-list/**")
public class MainCommunityController {

    @GetMapping("list")
    public String goToCommunityList() {
        return "/community-list/list";
    }

    @GetMapping("community-contents")
    public String goToCommunityContents() {
        return "/community-list/community-contents";
    }



}
