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
                .addPathPatterns("/")                                   //됨OOOOOOOO
                .addPathPatterns("/community-list/**")                  //됨OOOOOOOO
                .addPathPatterns("/customer-center/notice-list/**")     //됨OOOOOOOO
                .addPathPatterns("/customer-center/notice-detail/**")   //됨OOOOOOOO
                .addPathPatterns("/member/mypage")              //됨OOOOOOOO
                .addPathPatterns("/member/mypage/set")         //화면이 망가짐
                .addPathPatterns("/service/service-intro")      //됨OOOOOOOO
                .addPathPatterns("/pay/");                      //됨OOOOOOOO

//                아래 경로로 요청할 때는 실행하지 않음
//                .excludePathPatterns("/test/**");
    }
}
