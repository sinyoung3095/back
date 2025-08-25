package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class MemberProfileFileDTO {
    private Long id;
    private Long memberId;
    private String createdDate;
    private String updatedDate;
}
