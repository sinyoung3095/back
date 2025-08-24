package com.example.rebound.domain;

import com.example.rebound.audit.Period;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
@EqualsAndHashCode(of = "id")
public class OvercomeVO extends Period {
    private Long id;
    private String overcomeTitle;
    private String overcomeContent;
    private Long postId;
    private Long commentId;
    private Long memberId;
}
