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
    private int postViews;
    private Long memberId;
    private Status postStatus;
    private String createdDate;
    private String relativeDate;
    private String updatedDate;
}
