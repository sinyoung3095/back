package com.example.rebound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer-center/**")
public class CustomerCenterController {
//    공지사항 목록
    @GetMapping("notice-list")
    public String goTONoticeList(){
        return "/customer-center/notice-list";
    }
//    공지사항 상세
    @GetMapping("notice-detail")
    public String goToNoticeDetails() {
        return "notice-detail";
    }
//    문의
    @GetMapping("inquiry")
    public String goToInquiry() {
        return "/customer-center/inquiry";
    }
    @GetMapping("questions-list")
    public String goToQuestionsList() {
        return "/customer-center/questions-list";
    }
    @GetMapping("questions-detail")
    public String goToQuestionsDetail() {
        return "/customer-center/questions-detail";
    }
    @GetMapping("search")
    public String goToSearch() {
        return "/customer-center/search";
    }
}
