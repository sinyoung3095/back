package com.example.rebound.service;

import com.example.rebound.dto.MemberDTO;
import com.example.rebound.dto.PaymentDTO;
import com.example.rebound.dto.SubscribeDTO;
import com.example.rebound.repository.PaymentDAO;
import com.example.rebound.repository.SubscribeDAO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDAO paymentDAO;
    private final SubscribeDAO subscribeDAO;
    private final HttpSession session;

    //    첫 결제
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertPayment(SubscribeDTO subscribeDTO) {
        PaymentDTO paymentDTO = new PaymentDTO();
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        subscribeDAO.insertSubscribe(subscribeDTO);
        paymentDTO.setSubscribeId(subscribeDTO.getId());
        paymentDTO.setMemberId(memberDTO.getId());
//        paymentDTO.setMemberId(4L);
        // 로그인 대신 임시로 아이디 주입 -> 로그인 할 경우: 위의 주석 해제
        paymentDAO.insertPayment(paymentDTO);
    }

    //    n번째 결제
    @Override
    public void updatePayment(PaymentDTO paymentDTO) {
        paymentDAO.updatePaymeent(paymentDTO);
    }

    //    결제 조회
    @Override
    public List<PaymentDTO> selectPayment(int memberId) {
        return paymentDAO.selectPaymeent(memberId);
    }

}
