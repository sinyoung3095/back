package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CounselorDTO {
    private Long id;
    private String counselorName;
    private String counselorEmail;
    private String counselorPhoneNumber;
    private String counselorPassword;
    private String counselorAddress;
    private String counselorStatus;
    private String counselorApprovalStatus;
    private String createdDatetime;
    private String updatedDatetime;
}
