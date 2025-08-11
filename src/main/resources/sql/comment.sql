create table tbl_comment
(
    id              bigint unsigned auto_increment
        primary key,
    comment_content varchar(255)                       not null,
    created_date    datetime default CURRENT_TIMESTAMP null,
    updated_date    datetime default CURRENT_TIMESTAMP null,
    member_id       bigint unsigned                    null,
    post_id         bigint unsigned                    null,
    constraint fk_comment_member
        foreign key (member_id) references tbl_member (id),
    constraint fk_comment_post
        foreign key (post_id) references tbl_post (id)
);

