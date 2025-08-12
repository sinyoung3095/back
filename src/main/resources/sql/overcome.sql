
create table tbl_overcome
(
    id               bigint unsigned auto_increment
        primary key,
    overcome_title   varchar(255)                       not null,
    overcome_content varchar(255)                       not null,
    created_date     datetime default CURRENT_TIMESTAMP null,
    updated_date     datetime default CURRENT_TIMESTAMP null,
    post_id          bigint unsigned                    null,
    comment_id       bigint unsigned                    null,
    member_id        bigint unsigned                    null,
    constraint fk_overcome_comment
        foreign key (comment_id) references tbl_comment (id),
    constraint fk_overcome_member
        foreign key (member_id) references tbl_member (id),
    constraint fk_overcome_post
        foreign key (post_id) references tbl_post (id)
);

