package com.example.rebound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/**")
public class adminController {
    @GetMapping("admin-login")
    public String goToAdminLogin(){
        return "/admin/admin-login";
    }
    @GetMapping("admin-mainpage")
    public String goToAdminMainPage(){
        return "/admin/admin-mainpage";
    }
    @GetMapping("notice-list")
    public String goToNoticeList(){
        return "/admin/notice-list";
    }
    @GetMapping("notice-detail")
    public String goToNoticeDetail(){
        return "/admin/notice-detail";
    }
    @GetMapping("counseling-list")
    public String goToCounselingList(){
        return "/admin/counseling-list";
    }
    @GetMapping("counseling-apply")
    public String goToCounselingApply(){
        return "/admin/counseling-apply";
    }
    @GetMapping("counselor-list")
    public String goToCounselorList(){
        return "/admin/counselor-list";
    }
}
