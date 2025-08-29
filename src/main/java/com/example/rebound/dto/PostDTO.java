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
public class PostDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private int postReadCount;
    private Long memberId;
    private String memberName;
    private Long categoryId;
    private String categoryName;
    private Status postStatus;
    private int commentCount;
    private String filePath;
    private String fileName;
    private String createdDate;
    private String relativeDate;
    private String updatedDate;
}
