package com.example.rebound.domain;

import com.example.rebound.audit.Period;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter @ToString
@SuperBuilder
@EqualsAndHashCode(of ="id")
public class CounselorCommentVO extends Period {
//    id                        bigint unsigned auto_increment
//    primary key,
//    counselor_comment_comment varchar(255)                       not null,
//    created_date              datetime default CURRENT_TIMESTAMP null,
//    updated_date              datetime default CURRENT_TIMESTAMP null,
//    counselor_id              bigint unsigned                    null,
//    post_id                   bigint unsigned                    null,
    private Long id;
    private String counselorCommentComment;
    private Long counselorId;
    private Long postId;
}
