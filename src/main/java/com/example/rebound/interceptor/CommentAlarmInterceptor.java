package com.example.rebound.interceptor;

import com.example.rebound.service.CommentAlarmService;
import com.example.rebound.service.CommentAlarmServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class CommentAlarmInterceptor implements HandlerInterceptor {
    private CommentAlarmServiceImpl commentAlarmServiceImpl;

    //    전처리
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("test", "1234");
        return true;
    }
}
