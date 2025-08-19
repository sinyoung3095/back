package com.example.rebound.repository;

import com.example.rebound.dto.PaymentDTO;
import com.example.rebound.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PaymentDAO {
    private final PaymentMapper paymentMapper;

//    첫 결제
    public void insertPaymeent(PaymentDTO paymentDTO) {
        paymentMapper.insertPaymeent(paymentDTO);
    }

//    n번째 결재
    public void updatePaymeent(PaymentDTO paymentDTO) {
        paymentMapper.updatePayment(paymentDTO);
    }

//    결제 조회
    public List<PaymentDTO> selectPaymeent(PaymentDTO paymentDTO) {
        return paymentMapper.selectPayment(paymentDTO);
    }
}
