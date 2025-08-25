package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class LikeDTO {
    private Long id;
    private Long memberId;
    private Long commentId;
    private String createdDate;
    private String updatedDate;
}
