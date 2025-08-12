package com.example.rebound.domain;

import com.example.rebound.audit.Period;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper=true)
@EqualsAndHashCode(of="id")
@SuperBuilder
public class PaymentVO extends Period {

    private Long id;
    private String paymentStartDate;
    private String paymentUpdateDate;
    private Long subscribeId;
    private Long memberId;
}
