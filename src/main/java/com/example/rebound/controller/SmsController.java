package com.example.rebound.controller;

import com.example.rebound.service.MemberService;
import com.example.rebound.service.SmsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sms/**")
@Slf4j
public class SmsController {
    private final SmsService smsService;
    private final MemberService memberService;

    @PostMapping("/send")
    public ResponseEntity<?> sendSms(@RequestBody Map<String, String> request) {
        String memberPhoneNumber = request.get("memberPhoneNumber");
//        log.info("문자 전송 요청: {}", memberPhoneNumber);
        Map<String, Object> body = new HashMap<>();

        if (memberPhoneNumber == null) {
            body.put("success", false);
            body.put("message", "전화번호를 입력해주세요.");
            return ResponseEntity.ok(body);
        }

        if(memberService.findEmailByPhone(memberPhoneNumber) == null) {
            body.put("success", false);
            body.put("message", "가입되지 않은 전화번호입니다.");
            return ResponseEntity.ok(body);
        }

        String code = smsService.send(memberPhoneNumber);
        body.put(memberPhoneNumber, code);
        body.put("success", true);
        body.put("code", code);
        return ResponseEntity.ok(body);
    }

    @PostMapping("/checkCode")
    public ResponseEntity<?> checkCode(@RequestBody Map<String, String> request) {
        String inputCode = request.get("code");
        Map<String, Object> body = new HashMap<>();

        if(body.equals(inputCode)) {
            body.put("success", true);
            body.put("message", "인증 성공");
        } else {
            body.put("success", false);
            body.put("message", "인증번호가 일치하지 않습니다.");
        }

        return ResponseEntity.ok(body);
    }



}
