package com.example.rebound.controller;

import com.example.rebound.service.MailService;
import com.example.rebound.service.MemberService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/mail/**")
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;
    private final MemberService memberService;

//    메일 전송
    @PostMapping("send")
    public RedirectView send(String email, HttpServletRequest request, HttpServletResponse response) throws MessagingException {
        mailService.sendMail(email, request, response);
        return new RedirectView("/member/find-confirm");
    }

//    메일 인증
    @GetMapping("confirm")
    public RedirectView confirm(@CookieValue(name="code", required = false) String cookieCode,
                                String code,
                                String memberEmail,
                                HttpServletResponse response){
        if(cookieCode == null || cookieCode.isEmpty()){
            return new RedirectView("/mail/find-fail");
        }

        if(cookieCode.equals(code)){
            Cookie cookie = new Cookie("code", null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            return new RedirectView("/mail/new-password?memberEmail=" + memberEmail);
        }

        return new RedirectView("/mail/find-fail");
    }

//    비밀번호 변경
    @GetMapping("/new-password")
    public String goToNewPassword(@RequestParam String memberEmail, Model model) {
        model.addAttribute("memberEmail", memberEmail);
        return "member/new-password";
    }

    @PostMapping("update-password")
    public RedirectView updatePassword(String newPassword, String memberEmail) {
        memberService.updateMemberPassword(newPassword, memberEmail);
        System.out.println("이메일 = " + memberEmail);
        System.out.println("새 비밀번호 = " + newPassword);
        return new RedirectView("/member/login");
    }

    @GetMapping("/find-fail")
    public String goToMemberLogin() {
        return "member/find-fail";
    }
}
