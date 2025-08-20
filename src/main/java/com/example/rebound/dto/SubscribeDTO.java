package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class SubscribeDTO {
    private Long id;
    private int subscribePrice;
    private String createdDate;
    private String updatedDate;
}
