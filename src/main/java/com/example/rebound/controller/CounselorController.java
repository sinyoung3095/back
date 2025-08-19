package com.example.rebound.controller;

import com.example.rebound.common.exception.LoginFailException;
import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.CounselorQualificationsFileDTO;
import com.example.rebound.dto.FileDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.service.CounselorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/counselor/**")
public class CounselorController {
    private final CounselorService counselorService;

    public CounselorController(CounselorService counselorService) {
        this.counselorService = counselorService;
    }

    //    상담사 회원가입 페이지로 이동
    @GetMapping("join")
    public String goToCounselorJoin(CounselorDTO counselorDTO, Model model) {
        model.addAttribute("counselorDTO", counselorDTO);
        return "member/join-counselor";
    }

    //    이메일 중복 검사
    @PostMapping("check-email")
    @ResponseBody
    public ResponseEntity<?> checkEmail(@RequestBody Map<String, String> counselor){
        String counselorEmail = counselor.get("counselorEmail");

        boolean isExist = counselorService.isExistCounselorEmail(counselorEmail);
        Map<String, Object> result = new HashMap<>();
        result.put("counselorEmail", counselorEmail);
        result.put("isExist", isExist);

//        System.out.println("이메일 체크 실행");
        if(isExist){
//            System.out.println("이미 존재하는 이메일");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        return ResponseEntity.ok().body(result);
    }

    //    전화번호 중복 검사
    @PostMapping("check-phone-number")
    @ResponseBody
    public ResponseEntity<?> checkPhoneNumber(@RequestBody Map<String, String> counselor){
        String counselorPhoneNumber = counselor.get("counselorPhoneNumber");

        boolean isExist = counselorService.isExistCounselorPhoneNumber(counselorPhoneNumber);
        Map<String, Object> result = new HashMap<>();
        result.put("counselorPhoneNumber", counselorPhoneNumber);
        result.put("isExist", isExist);

//        System.out.println("전화번호 체크 실행");
        if(isExist){
//            System.out.println("이미 존재하는 전화번호");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        return ResponseEntity.ok().body(result);
    }

//    회원가입 완료
    @PostMapping("join")
    public RedirectView joinCounselor(CounselorDTO counselorDTO, @RequestParam("file") List<MultipartFile> counselorQualificationsFiles) {
        counselorService.joinCounselor(counselorDTO, counselorQualificationsFiles);
        return new RedirectView("/counselor/login");
    }

    //    로그인 페이지로 이동
    @GetMapping("login")
    public String goToLogin(CounselorDTO counselorDTO, Model model) {
        model.addAttribute("counselorDTO", counselorDTO);
        return "member/login-counselor";
    }

    //    로그인 완료
    @PostMapping("login")
    public RedirectView Login(CounselorDTO counselorDTO) {
        counselorService.login(counselorDTO).orElseThrow(LoginFailException::new);
        return new RedirectView("/main-page/page"); }
}
