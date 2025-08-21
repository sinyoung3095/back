package com.example.rebound.dto;

import com.example.rebound.common.enumeration.Status;
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
    private String memberName;
    private Long postId;
    private Status commentStatus;
    private String createdDate;
    private String updatedDate;
    private String relativeDate;
}
