create table tbl_post
(
    id           bigint unsigned auto_increment
        primary key,
    post_title   varchar(255)                           not null,
    post_content varchar(255)                           not null,
    post_read_count   int unsigned default '0'               null,
    post_status enum('active', 'inactive') default 'active',
    created_date datetime     default CURRENT_TIMESTAMP null,
    updated_date datetime     default CURRENT_TIMESTAMP null,
    member_id    bigint unsigned                        null,
    category_id bigint unsigned,
    constraint fk_post_member
        foreign key (member_id) references tbl_member (id),
    constraint fk_post_category foreign key(category_id) references tbl_category(id)
);

select * from tbl_post;

select * from tbl_member;
select * from tbl_category;

insert into tbl_post(post_content, post_title, category_id, member_id)
values ('테스트내용2','테스트제목2', 1,1);




