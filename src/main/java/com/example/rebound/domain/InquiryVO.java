package com.example.rebound.domain;


import com.example.rebound.audit.Period;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter @ToString(callSuper = true)
@EqualsAndHashCode(of = "id")
@SuperBuilder
public class InquiryVO extends Period {

    Long id;
    String inquiryTitle;
    String inquiryContent;
    String inquiryEmail;
    Long memberId;
}
