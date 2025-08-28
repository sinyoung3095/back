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
        Map<String, Object> body = new HashMap<>();

        if (memberPhoneNumber == null) {
            body.put("success", false);
            return ResponseEntity.ok(body);
        }

        if(memberService.findEmailByPhone(memberPhoneNumber) == null) {
            body.put("success", false);
            return ResponseEntity.ok(body);
        } else {
            body.put("success", true);
            body.put("code", smsService.send(memberPhoneNumber));
        }

        return ResponseEntity.ok(body);
    }

    @PostMapping("/find-email")
    public ResponseEntity<?> findEmail(@RequestBody Map<String, String> request) {
        String memberPhoneNumber = request.get("memberPhoneNumber");
        Map<String, Object> body = new HashMap<>();

        if (memberService.findEmailByPhone(memberPhoneNumber) == null) {
            body.put("success", false);
        } else {
            body.put("success", true);
            body.put("email", memberService.findEmailByPhone(memberPhoneNumber));
        }
        return ResponseEntity.ok(body);
    }

}
