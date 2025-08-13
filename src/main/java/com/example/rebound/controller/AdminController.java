package com.example.rebound.controller;


import com.example.rebound.dto.MemberDTO;
import com.example.rebound.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin/**")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

//    관리자 로그인페이지 이동
    @GetMapping("admin-login")
    public String goToAdminLogin(){
        return "/admin/admin-login";
    }
//    로그인 성공시 관리자 메인 페이지 이동
    @PostMapping("admin-login")
    public RedirectView adminLogin(MemberDTO memberDTO){
        if(!(adminService.checkAdmin(memberDTO)==null)){
            return new RedirectView("/admin/admin-mainpage");
        };return new RedirectView("/admin/admin-login");
    }
//    관리자 메인페이지 이동
    @GetMapping("admin-mainpage")
    public String goToAdminMainPage(){
        return "/admin/admin-mainpage";
    }
//    관리자 공지사항 목록 이동
    @GetMapping("notice-list")
    public String goToNoticeList(){
        return "/admin/notice-list";
    }
//    관리자 공지사항 상세 이동
    @GetMapping("notice-detail")
    public String goToNoticeDetail(){
        return "/admin/notice-detail";
    }
//    상담하기 목록 이동
    @GetMapping("counseling-list")
    public String goToCounselingList(){
        return "/admin/counseling-list";
    }
//    상담사 댓글 이동
    @GetMapping("counselor-apply")
    public String goToCounselingApply(){
        return "/admin/counselor-apply";
    }
//    상담사 목록 이동
    @GetMapping("counselor-list")
    public String goToCounselorList(){
        return "/admin/counselor-list";
    }
//    일반 멤버 목록 이동
    @GetMapping("general-memberlist")
    public String goToGeneralMemberList(){
        return "/admin/general-memberlist";
    }
//    멘토 목록 이동
    @GetMapping("mentor-memberlist")
    public String goToMentorMemberList(){
        return "/admin/mentor-memberlist";
    }
//    구독자 목록 이동
    @GetMapping("subscribe-memberlist")
    public String goToSubscribeMemberList(){
        return "/admin/subscribe-memberlist";
    }
}
