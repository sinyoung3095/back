package com.example.rebound.common.exception.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class NotFound {
    @GetMapping("/error")
    public String toGoMain(){
        log.info("sfdsf");
        return "/main-page/page";
    }
}
