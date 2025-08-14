package com.example.rebound.service;

import com.example.rebound.dto.MemberDTO;

public interface MemberService {
//    회원 회원가입
    public void joinMember(MemberDTO memberDTO);
//    회원 이메일 중복 검사
    public boolean isExistMemberEmail(String memberEmail);
//    회원 번호 중복 검사
    public boolean isExistMemberPhoneNumber(String memberPhoneNumber);
}
