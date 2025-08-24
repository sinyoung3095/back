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

select * from tbl_post;

delete from tbl_post where post_status = 'active';

alter table tbl_post add column(post_status enum('active', 'inactive') default 'active');
alter table tbl_post add column(category_id bigint unsigned);
alter table tbl_post add constraint fk_post_category foreign key(category_id) references tbl_category(id);


insert into tbl_post(post_content,post_title,member_id)
values ("테스트내용2","테스트제목2",123);




