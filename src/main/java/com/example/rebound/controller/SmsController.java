package com.example.rebound.controller;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.service.CounselorService;
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
    private final CounselorService counselorService;

    @PostMapping("/send")
    public ResponseEntity<?> sendSms(@RequestBody Map<String, String> request) {
        String phoneNumber = request.get("memberPhoneNumber");
        Map<String, Object> body = new HashMap<>();

        if (phoneNumber == null || phoneNumber.isEmpty()) {
            body.put("success", false);
            body.put("message", "전화번호가 없습니다.");
            return ResponseEntity.ok(body);
        }

        MemberDTO member = memberService.findEmailByPhone(phoneNumber);
        CounselorDTO counselor = counselorService.findEmailByPhone(phoneNumber);
        if (member == null && counselor == null) {
            body.put("success", false);
            body.put("message", "가입된 계정을 찾을 수 없습니다.");
            return ResponseEntity.ok(body);
        }

        body.put("success", true);
        body.put("code", smsService.send(phoneNumber));
        return ResponseEntity.ok(body);
    }

    @PostMapping("/find-email")
    public ResponseEntity<?> findEmail(@RequestBody Map<String, String> request) {
        String phoneNumber = request.get("memberPhoneNumber");
        Map<String, Object> body = new HashMap<>();

        if (phoneNumber == null || phoneNumber.isEmpty()) {
            body.put("success", false);
            body.put("message", "전화번호가 없습니다.");
            return ResponseEntity.ok(body);
        }

        MemberDTO member = memberService.findEmailByPhone(phoneNumber);
        CounselorDTO counselor = counselorService.findEmailByPhone(phoneNumber);

        if (member != null) {
            body.put("success", true);
            body.put("email", member.getMemberEmail());
        } else if (counselor != null) {
            body.put("success", true);
            body.put("email", counselor.getCounselorEmail());
        } else {
            body.put("success", false);
            body.put("message", "가입된 계정을 찾을 수 없습니다.");
        }

        return ResponseEntity.ok(body);
    }

}
