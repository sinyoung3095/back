package com.example.rebound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/**")
public class AdminController {
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
    @GetMapping("counselor-apply")
    public String goToCounselingApply(){
        return "/admin/counselor-apply";
    }
    @GetMapping("counselor-list")
    public String goToCounselorList(){
        return "/admin/counselor-list";
    }
    @GetMapping("general-memberlist")
    public String goToGeneralMemberList(){
        return "/admin/general-memberlist";
    }
    @GetMapping("mentor-memberlist")
    public String goToMentorMemberList(){
        return "/admin/mentor-memberlist";
    }
    @GetMapping("subscribe-memberlist")
    public String goToSubscribeMemberList(){
        return "/admin/subscribe-memberlist";
    }
}
