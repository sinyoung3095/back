
create table tbl_post
(
    id           bigint unsigned auto_increment
        primary key,
    post_content varchar(255)                           not null,
    post_title   varchar(255)                           not null,
    post_views   int unsigned default '0'               null,
    created_date datetime     default CURRENT_TIMESTAMP null,
    updated_date datetime     default CURRENT_TIMESTAMP null,
    member_id    bigint unsigned                        null,
    constraint fk_post_member
        foreign key (member_id) references tbl_member (id)
);

alter table tbl_post add post_status enum('active', 'inactive') default 'active';

select * from tbl_post;

insert into tbl_post(post_title, post_content, member_id)
    (select post_title, post_content, member_id from tbl_post);

select count(*) from tbl_post;

