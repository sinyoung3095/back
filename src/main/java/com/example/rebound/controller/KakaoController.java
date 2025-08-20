package com.example.rebound.controller;

import com.example.rebound.dto.MemberDTO;
import com.example.rebound.service.KakaoService;
import com.example.rebound.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class KakaoController {
    private final KakaoService kakaoService;
    private final MemberService memberService;
    private final HttpSession session;

    @GetMapping("/kakao/login")
    public RedirectView kakaoLogin(String code){
        String token=kakaoService.getKakaoAccessToken(code);
        Optional<MemberDTO> foundMember=kakaoService.getKakaoInfo(token);
        MemberDTO memberDTO=foundMember.orElseThrow(RuntimeException::new);
        String path=null;

//        최초 로그인인지 검사
        Optional<MemberDTO> foundKakaoMember=memberService.findMemberByKakaoEmail(memberDTO.getKakaoEmail());
        if(foundKakaoMember.isEmpty()){
            memberService.joinKakaoMember(memberDTO);

            return new RedirectView("/member/login-kakao");
//            foundKakaoMember=memberService.findMemberByKakaoEmail(memberDTO.getKakaoEmail());
        }
        session.setAttribute("member", foundKakaoMember.get());

        return new RedirectView("/main-page/page");
        
//        이슈 확인
//        완료
    }
    @PostMapping("kakao/login")
    public RedirectView kakaoLogin(Optional<MemberDTO> foundKakaoMember, MemberDTO memberDTO){
        foundKakaoMember=memberService.findMemberByKakaoEmail(memberDTO.getKakaoEmail());
        session.setAttribute("member", foundKakaoMember.get());
        return new RedirectView("/main-page/page");
    }
}
