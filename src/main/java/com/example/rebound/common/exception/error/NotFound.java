package com.example.rebound.common.exception.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class NotFound {
    @GetMapping("/error")
    public String toGoMain(){
        return "/main-page/page";
    }
}
