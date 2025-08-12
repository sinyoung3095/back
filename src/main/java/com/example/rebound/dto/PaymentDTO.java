package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class PaymentDTO {
    private Long id;
    private String paymentStartDate;
    private String paymentUpdateDate;
    private Long subscribeId;
    private Long memberId;
    private String createdDate;
    private String updatedDate;
}
