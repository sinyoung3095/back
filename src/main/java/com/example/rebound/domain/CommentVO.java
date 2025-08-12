package com.example.rebound.domain;

import com.example.rebound.audit.Period;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter @ToString
@SuperBuilder
@EqualsAndHashCode(of = "id")
public class CommentVO extends Period {
//    id              bigint unsigned auto_increment
//    primary key,
//    comment_content varchar(255)                       not null,
//    created_date    datetime default CURRENT_TIMESTAMP null,
//    updated_date    datetime default CURRENT_TIMESTAMP null,
//    member_id       bigint unsigned                    null,
//    post_id         bigint unsigned                    null,
    private Long id;
    private String commentContent;
    private Long memberId;
    private Long postId;
}
