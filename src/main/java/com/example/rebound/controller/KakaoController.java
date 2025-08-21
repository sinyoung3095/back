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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class KakaoController {
    private final KakaoService kakaoService;
    private final MemberService memberService;
    private final HttpSession session;

    @GetMapping("/kakao/login")
    public String kakaoLogin(@RequestParam("code") String code, Model model) {
        String token = kakaoService.getKakaoAccessToken(code);
        Optional<MemberDTO> foundMember = kakaoService.getKakaoInfo(token);
        MemberDTO memberDTO = foundMember.orElseThrow(RuntimeException::new);

        Optional<MemberDTO> foundKakaoMember = memberService.findMemberByKakaoEmail(memberDTO.getKakaoEmail());

        if (foundKakaoMember.isEmpty()) {
            memberDTO.setMemberProvider(Provider.KAKAO);
            memberDTO.setMemberEmail(memberDTO.getKakaoEmail());
            memberDTO.setKakaoProfileUrl(memberDTO.getKakaoProfileUrl());

            model.addAttribute("memberDTO", memberDTO);
            return "/member/login-kakao";
        }

        session.setAttribute("member", foundKakaoMember.get());
        return "/member/mypage";
    }

    @PostMapping("/member/join-kakao")
    public RedirectView joinKakao(@ModelAttribute MemberDTO memberDTO) {
//        System.out.println(memberDTO.getMemberEmail());
//        System.out.println(memberDTO.getKakaoProfileUrl());
//        System.out.println(memberDTO.getMemberProvider());
        memberService.joinKakaoMember(memberDTO);
        memberService.saveKakaoProfile(memberDTO);
        session.setAttribute("member", memberDTO);
        return new RedirectView("/member/mypage");
    }

}
