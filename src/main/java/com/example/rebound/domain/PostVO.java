package com.example.rebound.domain;

import com.example.rebound.audit.Period;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter @ToString
@SuperBuilder
@EqualsAndHashCode(of = "id")
public class PostVO extends Period {
//    id           bigint unsigned auto_increment
//    primary key,
//    post_content varchar(255)                           not null,
//    post_title   varchar(255)                           not null,
//    post_views   int unsigned default '0'               null,
//    created_date datetime     default CURRENT_TIMESTAMP null,
//    updated_date datetime     default CURRENT_TIMESTAMP null,
//    member_id    bigint unsigned                        null,
//    constraint fk_post_member
//    foreign key (member_id) references tbl_member (id)
    private Long id;
    private String postTitle;
    private String postContent;
    private int postViews;
    private Long memberId;
}
