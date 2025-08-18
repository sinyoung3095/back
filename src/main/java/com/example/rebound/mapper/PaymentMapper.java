package com.example.rebound.mapper;

import com.example.rebound.dto.PaymentDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    public void goToPayment(PaymentDTO paymentDTO);
}
