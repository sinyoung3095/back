package com.example.rebound.service;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.dto.PaymentDTO;

import java.util.List;
import java.util.Optional;

public interface MemberService {
//    회원 회원가입
    public void joinMember(MemberDTO memberDTO);
//    회원 이메일 중복 검사
    public boolean isExistMemberEmail(String memberEmail);
//    회원 번호 중복 검사
    public boolean isExistMemberPhoneNumber(String memberPhoneNumber);
//    회원 로그인
    public Optional<MemberDTO> login(MemberDTO memberDTO);

//    첫 결제
    public void insertPayment(PaymentDTO paymentDTO);
//    n번째 결제
    public void updatePayment(PaymentDTO paymentDTO);
//    결제 조회
    public List<PaymentDTO> selectPayment(PaymentDTO paymentDTO);
}
