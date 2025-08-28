package com.example.rebound.controller;

import com.example.rebound.service.MemberService;
import com.example.rebound.service.SmsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sms/**")
@Slf4j
public class SmsController {
    private final SmsService smsService;

    @PostMapping("/send")
    public ResponseEntity<?> sendSms(@RequestBody Map<String, String> request) {
        String memberPhoneNumber = request.get("memberPhoneNumber");
        log.info("문자 전송 요청: {}", memberPhoneNumber);

        String code = smsService.send(memberPhoneNumber);

        return ResponseEntity.ok(Map.of("success", true, "code", code));
    }
}
