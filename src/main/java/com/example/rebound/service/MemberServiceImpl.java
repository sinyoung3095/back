package com.example.rebound.service;

import com.example.rebound.dto.CounselorDTO;
import com.example.rebound.dto.MemberDTO;
import com.example.rebound.dto.PaymentDTO;
import com.example.rebound.repository.CounselorDAO;
import com.example.rebound.repository.MemberDAO;
import com.example.rebound.repository.PaymentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Primary
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    private final PaymentDAO paymentDAO;

    @Override
    public void joinMember(MemberDTO memberDTO) {
        memberDAO.save(memberDTO);
    }

    @Override
    public boolean isExistMemberEmail(String memberEmail) {
        return memberDAO.isExistMemberEmail(memberEmail);
    }

    @Override
    public boolean isExistMemberPhoneNumber(String memberPhoneNumber) {
        return memberDAO.isExistMemberPhoneNumber(memberPhoneNumber);
    }

    @Override
    public Optional<MemberDTO> login(MemberDTO memberDTO) {
        return memberDAO.findMemberByEmailAndPassword(memberDTO);
    }

//    첫 결제
    @Override
    public void insertPayment(PaymentDTO paymentDTO) {
        paymentDAO.insertPaymeent(paymentDTO);
    }
//    n번째 결제
    @Override
    public void updatePayment(PaymentDTO paymentDTO) {
        paymentDAO.updatePaymeent(paymentDTO);
    }
//    결제 조회
    @Override
    public List<PaymentDTO> selectPayment(PaymentDTO paymentDTO) {
        return paymentDAO.selectPaymeent(paymentDTO);
    }

}
