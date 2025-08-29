package com.example.rebound.controller;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.service.CounselorService;
import com.example.rebound.service.MailService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/counselor/mail/**")
@RequiredArgsConstructor
public class CounselorMailController {
    private final MailService mailService;
    private final CounselorService counselorService;

    //    메일 전송
    @PostMapping("send")
    public RedirectView send(String email, HttpServletRequest request, HttpServletResponse response) throws MessagingException {
        if(!counselorService.isExistCounselorEmail(email)) {
            return new RedirectView("/counselor/mail/notfound-email");
        }
        mailService.sendMail(email, request, response);
        return new RedirectView("/counselor/mail/find-confirm");
    }

    //    메일 인증
    @GetMapping("confirm")
    public RedirectView confirm(@CookieValue(name="code", required = false) String cookieCode,
                                String code,
                                String counselorEmail,
                                HttpServletResponse response){
        if(cookieCode == null || cookieCode.isEmpty()){
            return new RedirectView("/counselor/mail/find-fail");
        }

        if(cookieCode.equals(code)){
            Cookie cookie = new Cookie("code", null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            return new RedirectView("/counselor/mail/new-password?counselorEmail=" + counselorEmail);
        }

        return new RedirectView("/counselor/mail/find-fail");
    }

    //    비밀번호 변경
    @GetMapping("/new-password")
    public String goToNewPassword(@RequestParam String counselorEmail, Model model) {
        model.addAttribute("counselorEmail", counselorEmail);
        return "counselor/new-password";
    }

    @PostMapping("new-password")
    @ResponseBody
    public ResponseEntity<?> newPassword(@RequestBody CounselorDTO counselorDTO) {
        counselorService.updateCounselorPassword(counselorDTO.getCounselorPassword(), counselorDTO.getCounselorEmail());
        Map<String, String> body = new HashMap<>();
        body.put("message", "비밀번호 변경 완료");
        return ResponseEntity.ok(body);
    }

    @GetMapping("/find-fail")
    public String goToMemberLogin() {
        return "counselor/find-fail";
    }

    @GetMapping("/notfound-email")
    public String goToNotFoundEmail() {
        return "counselor/notfound-email";
    }
}
