package com.example.rebound.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InquiryFileVO {
    private Long id;
    private Long inquiryId;
}
