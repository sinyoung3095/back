package com.example.rebound.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class CounselorCommentDTO {
    private Long id;
    private String counselorCommentComment;
    private Long counselorId;
    private Long postId;
    private String createdDate;
    private String updatedDate;
}
