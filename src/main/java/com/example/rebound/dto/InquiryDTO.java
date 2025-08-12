package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString @NoArgsConstructor
@EqualsAndHashCode(of="id")
public class InquiryDTO {
    Long id;
    String inquiryTitle;
    String inquiryContent;
    String inquiryEmail;
    Long memberId;
    String createdDate;
    String updatedDate;
}
