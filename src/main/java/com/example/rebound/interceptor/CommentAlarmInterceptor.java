package com.example.rebound.interceptor;

import com.example.rebound.dto.CommentAlarmDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.service.CommentAlarmService;
import com.example.rebound.service.CommentAlarmServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommentAlarmInterceptor implements HandlerInterceptor {
    private final CommentAlarmService commentAlarmService;

    //    전처리
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MemberDTO member = (MemberDTO) request.getSession().getAttribute("member");
        if(member != null){
            request.setAttribute("commentAlarms", commentAlarmService.getComments(member.getId()));
        }

        return true;
    }
}
