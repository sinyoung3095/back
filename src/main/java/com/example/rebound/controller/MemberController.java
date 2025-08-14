package com.example.rebound.controller;

import com.example.rebound.dto.MemberDTO;
import com.example.rebound.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member/**")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("join")
    public String goToMemberJoin(MemberDTO memberDTO, Model model) {
        model.addAttribute("memberDTO", memberDTO);
        return "member/join-user";
    }

    @PostMapping("join")
    public RedirectView MemberJoin(MemberDTO memberDTO) {
        memberService.joinMember(memberDTO);
        return new RedirectView("/member/login");
    }

    @PostMapping("check-email")
    @ResponseBody
    public ResponseEntity<?> checkEmail(@RequestBody Map<String, String> member){
        String memberEmail = member.get("memberEmail");

        boolean isExist = memberService.isExistMemberEmail(memberEmail);
        Map<String, Object> result = new HashMap<>();
        result.put("memberEmail", memberEmail);
        result.put("isExist", isExist);

//        System.out.println("이메일 체크 실행");
        if(isExist){
//            System.out.println("이미 존재하는 이메일");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("check-phone-number")
    @ResponseBody
    public ResponseEntity<?> checkPhoneNumber(@RequestBody Map<String, String> member){
        String memberPhoneNumber = member.get("memberPhoneNumber");

        boolean isExist = memberService.isExistMemberPhoneNumber(memberPhoneNumber);
        Map<String, Object> result = new HashMap<>();
        result.put("memberPhoneNumber", memberPhoneNumber);
        result.put("isExist", isExist);

//        System.out.println("전화번호 체크 실행");
        if(isExist){
//            System.out.println("이미 존재하는 전화번호");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("join-counselor")
    public String goToCounselorJoin(){
        return "member/join-counselor";
    }
    @GetMapping("login")
    public String goToLogin(){
        return "member/login";
    }
    @GetMapping("find-email")
    public String goToFindEmail(){
        return "member/find-email";
    }
    @GetMapping("find-email/ok")
    public String goToFindEmailOk(){
        return "member/find-email-ok";
    }
    @GetMapping("new-password")
    public String goToNewPassword(){
        return "member/new-fassword";
    }
    @GetMapping("mypage")
    public String goToMyPage(){
        return "member/mypage";
    }
    @GetMapping("mypage/info")
    public String goToMyPageInfo(){
        return "member/mypage-info";
    }
    @GetMapping("mypage/post")
    public String goToMyPagePost(){
        return "member/mypage-post";
    }
    @GetMapping("mypage/reply")
    public String goToMyPageReply(){
        return "member/mypage-reply";
    }
    @GetMapping("mypage/set")
    public String goToMyPageSet(){
        return "member/mypage-set";
    }
    @GetMapping("mypage-counselor")
    public String goToMyPageCounselor(){
        return "member/counselor-mypage";
    }
    @GetMapping("mypage-couselor/info")
    public String goToMyPageCouselorInfo(){
        return "member/mypage-counselor-info";
    }
    @GetMapping("mypage-counselor/post")
    public String goToMyPageCounselorPost(){
        return "member/mypage-counselor-post";
    }
    @GetMapping("mypage-counselor/reply")
    public String goToMyPageCounselorReply(){
        return "member/mypage-counselor-reply";
    }
    @GetMapping("mypage-counselor/set")
    public String goToMyPageCounselorSet(){
        return "member/mypage-counselor-set";
    }
    @GetMapping("mypage-counselor/consultation/history")
    public String goToMyPageCounselorConsultationHistory(){
        return "member/mypage-counselor-consultation-history";
    }
    @GetMapping("mypage/consultation/history")
    public String goToAyPageConsultationHistory(){
        return "member/mypage-consultation-history";
    }
    @GetMapping("mypage-consultation/review")
    public String goToMyPageConsultationReview(){
        return "member/mypage-consultation-review";
    }
    @GetMapping("payment")
    public String goToPayment(){
        return "member/payment";
    }
}
