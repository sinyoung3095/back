package com.example.rebound.domain;

import com.example.rebound.audit.Period;
import com.example.rebound.common.enumeration.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter @ToString
@SuperBuilder
@EqualsAndHashCode(of = "id")
public class PostVO extends Period {
    private Long id;
    private String postContent;
    private String postTitle;
    private int postReadCount;
    private Long memberId;
    private Status postStatus;
    private Long categoryId;
    private String categoryName;
    private int commentCount;
}
