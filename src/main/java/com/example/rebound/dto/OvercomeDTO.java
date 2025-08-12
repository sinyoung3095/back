package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class OvercomeDTO {
    private Long id;
    private String overcomeTitle;
    private String overcomeContent;
    private Long postId;
    private Long commentId;
    private Long memberId;
    private String createdDate;
    private String updatedDate;
}
