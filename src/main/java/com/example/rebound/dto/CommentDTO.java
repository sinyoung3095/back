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
    private int likesCount;
    private boolean checkedLike;
    private Status commentStatus;
    private Long memberId;
    private String memberName;
    private String memberGrade;
    private Long postId;
    private String filePath;
    private String fileName;
    private String createdDate;
    private String updatedDate;
    private String relativeDate;
    private Long postMemberId;
}
