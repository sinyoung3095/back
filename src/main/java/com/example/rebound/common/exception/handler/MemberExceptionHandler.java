package com.example.rebound.common.exception.handler;

import com.example.rebound.common.exception.LoginFailCounselorException;
import com.example.rebound.common.exception.LoginFailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice(basePackages="com.example.rebound.controller")
public class MemberExceptionHandler {
    @ExceptionHandler(LoginFailException.class)
    protected RedirectView handleLoginFailException(LoginFailException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("login", "fail");
        return new RedirectView("/member/login");
    }
    @ExceptionHandler(LoginFailCounselorException.class)
    protected RedirectView handleLoginFailCounselorException(LoginFailCounselorException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("login", "fail");
        return new RedirectView("/counselor/login");
    }
}
