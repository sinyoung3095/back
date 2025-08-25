package com.example.rebound.controller;

import com.example.rebound.common.enumeration.Provider;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.service.KakaoService;
import com.example.rebound.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class KakaoController {

    private final KakaoService kakaoService;
    private final MemberService memberService;
    private final HttpSession session;

    @GetMapping("/kakao/login")
    public String kakaoLogin(String code, Model model) {
        String token = kakaoService.getKakaoAccessToken(code);
        Optional<MemberDTO> foundMemberOpt = kakaoService.getKakaoInfo(token);

        if (foundMemberOpt.isEmpty()) {
            // Kakao 정보 못 가져오면 로그인 페이지로 이동
            return "redirect:/member/login?error=kakao";
        }

        MemberDTO kakaoMember = foundMemberOpt.get();
        Optional<MemberDTO> foundKakaoMember = memberService.findMemberByKakaoEmail(kakaoMember.getKakaoEmail());

        if (foundKakaoMember.isEmpty()) {
            // 신규 카카오 회원
            kakaoMember.setMemberProvider(Provider.KAKAO);
            kakaoMember.setMemberEmail(kakaoMember.getKakaoEmail());

            model.addAttribute("memberDTO", kakaoMember);
            return "member/login-kakao";
        }

        // 기존 회원
        session.setAttribute("member", foundKakaoMember.get());
        return "redirect:/member/mypage";
    }
}
