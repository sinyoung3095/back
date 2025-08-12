package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString @NoArgsConstructor
@EqualsAndHashCode(of="id")
public class InquiryDTO {
    private Long id;
    private String inquiryTitle;
    private String inquiryContent;
    private String inquiryEmail;
    private Long memberId;
    private String createdDate;
    private String updatedDate;
}
