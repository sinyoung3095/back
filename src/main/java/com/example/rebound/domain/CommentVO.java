package com.example.rebound.domain;

import com.example.rebound.audit.Period;
import com.example.rebound.common.enumeration.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
@EqualsAndHashCode(of = "id")
public class CommentVO extends Period {
    private Long id;
    private String commentContent;
    private Status commentStatus;
    private Long memberId;
    private Long postId;
    private String relativeDate;
}
