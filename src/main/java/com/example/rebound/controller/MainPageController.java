package com.example.rebound.controller;

import com.example.rebound.common.exception.PostNotFoundException;
import com.example.rebound.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainPageController {
    private final MainPageService mainpageService;

    @GetMapping("/")
    public String goToMainpage(Model model) {
        model.addAttribute("posts", mainpageService.postPreview());
        model.addAttribute("todayMessages", mainpageService.todayMessagePreview());
        model.addAttribute("notices", mainpageService.noticePreview());
        return "/main-page/page";
    }

    @GetMapping("today-message")
    public String goToTodayMessage() {
        return "/counselor-list/good-words";
    }
}

