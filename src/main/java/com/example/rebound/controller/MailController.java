package com.example.rebound.controller;

import com.example.rebound.service.MailService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/mail/**")
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @PostMapping("send")
    public RedirectView send(String email, HttpServletRequest request, HttpServletResponse response) throws MessagingException {
        mailService.sendMail(email, request, response);
        return new RedirectView("/member/find-confirm");
    }

    @GetMapping("confirm")
    public RedirectView confirm(@CookieValue(name="code", required = false) String cookieCode,
                                String code,
                                HttpServletResponse response){
        if(cookieCode == null || cookieCode.isEmpty()){
            return new RedirectView("/mail/find-fail");
        }

        if(cookieCode.equals(code)){
            Cookie cookie = new Cookie("code", null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            return new RedirectView("/mail/new-password");
        }

        return new RedirectView("/mail/find-fail");
    }

    @GetMapping("/new-password")
    public String goToNewPassword() {
        return "member/new-password";
    }

    @GetMapping("/find-fail")
    public String goToMemberLogin() {
        return "member/find-fail";
    }
}
