package com.example.rebound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer-center/**")
public class GongjiController {
    @GetMapping("gongji-details")
    public String goToGongjiDetails() {
        return "/customer-center/gongji-details";
    }
}
