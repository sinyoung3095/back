package com.example.rebound.common.exception.handler;

import com.example.rebound.common.exception.PostNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice(basePackages = "com.example.rebound.controller")
public class PostExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    protected RedirectView handlePostNotFoundException(PostNotFoundException e) {
        return new RedirectView("/community-list/community-posts");
    }
}
