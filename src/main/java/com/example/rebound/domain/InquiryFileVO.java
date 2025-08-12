package com.example.rebound.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@EqualsAndHashCode(of = "id")
@SuperBuilder
public class InquiryFileVO {
    private Long id;
    private Long inquiryId;
}
