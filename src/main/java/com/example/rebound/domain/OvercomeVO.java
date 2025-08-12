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
//    id               bigint unsigned auto_increment
//    primary key,
//    overcome_title   varchar(255)                       not null,
//    overcome_content varchar(255)                       not null,
//    created_date     datetime default CURRENT_TIMESTAMP null,
//    updated_date     datetime default CURRENT_TIMESTAMP null,
//    post_id          bigint unsigned                    null,
//    comment_id       bigint unsigned                    null,
//    member_id        bigint unsigned                    null,
    private Long id;
    private String overcomeTitle;
    private String overcomeContent;
    private Long postId;
    private Long commentId;
    private Long memberId;
}
