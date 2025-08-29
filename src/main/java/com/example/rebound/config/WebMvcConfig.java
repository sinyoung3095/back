package com.example.rebound.config;

import com.example.rebound.interceptor.CommentAlarmInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final CommentAlarmInterceptor commentAlarmInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commentAlarmInterceptor)
//                아래 경로로만 요청할 때 실행
                .addPathPatterns("/")                                   
                .addPathPatterns("/community-list/**")
                .addPathPatterns("/api/community-posts/**")
                .addPathPatterns("/customer-center/notice-list/**")     
                .addPathPatterns("/customer-center/notice-detail/**")   
                .addPathPatterns("/member/mypage")              
                .addPathPatterns("/member/mypage/set")
                .addPathPatterns("/service/service-intro")
                .addPathPatterns("/customer-center/inquiry")
                .addPathPatterns("/pay/");                      

//                아래 경로로 요청할 때는 실행하지 않음
//                .excludePathPatterns("/test/**");
    }
}
