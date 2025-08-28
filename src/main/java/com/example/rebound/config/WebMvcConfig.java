package com.example.rebound.config;

import com.example.rebound.interceptor.CommentAlarmInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CommentAlarmInterceptor())
//                아래 경로로만 요청할 때 실행
                .addPathPatterns("/community-list/**")
                .addPathPatterns("/counselor-list/**")
                .addPathPatterns("/customer-center/**")
                .addPathPatterns("/member/mypage/**")
                .addPathPatterns("/customer-center/payment");

//                아래 경로로 요청할 때는 실행하지 않음
//                .excludePathPatterns("/test/**");
    }
}
