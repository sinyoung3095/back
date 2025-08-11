
create table tbl_counselor_comment
(
    id                        bigint unsigned auto_increment
        primary key,
    counselor_comment_comment varchar(255)                       not null,
    created_date              datetime default CURRENT_TIMESTAMP null,
    updated_date              datetime default CURRENT_TIMESTAMP null,
    counselor_id              bigint unsigned                    null,
    post_id                   bigint unsigned                    null,
    constraint fk_counselor_comment_counselor
        foreign key (counselor_id) references tbl_counselor (id),
    constraint fk_counselor_comment_post
        foreign key (post_id) references tbl_post (id)
);

