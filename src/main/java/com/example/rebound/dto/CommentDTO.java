package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class CommentDTO {
    private Long id;
    private String commentContent;
    private Long memberId;
    private Long postId;
    private String createdDate;
    private String updatedDate;
}
