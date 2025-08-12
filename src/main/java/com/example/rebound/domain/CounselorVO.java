package com.example.rebound.domain;

import com.example.rebound.audit.Period;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter @ToString
@SuperBuilder
@EqualsAndHashCode(of = "id")
public class CounselorVO extends Period {
    private Long id;
    private String counselorName;
    private String counselorEmail;
    private Long counselorPhoneNumber;
    private String counselorPassword;
    private String counselorAddress;
    private String counselorStatus;
    private String counselorApprovalStatus;
}
