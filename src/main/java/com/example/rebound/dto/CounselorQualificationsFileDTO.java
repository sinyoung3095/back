package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CounselorQualificationsFileDTO {
    private Long id;
    private Long counselorId;
    private String createdDatetime;
    private String updatedDatetime;
}
