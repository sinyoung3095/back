package com.example.rebound.controller;

import com.example.rebound.service.MainpageService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main-page/**")
@RequiredArgsConstructor
public class MainpageController {
    private final MainpageService mainpageService;

//    @GetMapping("page")
//    public String goToMainpage() {
//        return "/main-page/page";
//    }

    @GetMapping("page")
    public String List(Model model) {
        model.addAttribute("posts", mainpageService.getLists());
        return "/main-page/page";
    }
}

