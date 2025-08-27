create table tbl_comment
(
    id              bigint unsigned auto_increment
        primary key,
    comment_content varchar(255)                       not null,
    likes_count int default 0,
    comment_status enum('active', 'inactive') default 'active',
    created_date    datetime default CURRENT_TIMESTAMP null,
    updated_date    datetime default CURRENT_TIMESTAMP null,
    member_id       bigint unsigned                    null,
    post_id         bigint unsigned                    null,
    constraint fk_comment_member
        foreign key (member_id) references tbl_member (id),
    constraint fk_comment_post
        foreign key (post_id) references tbl_post (id)
);

insert into tbl_comment (comment_content, member_id, post_id)
values ('댓글 내용2', 1, 18);

select * from tbl_post;

select * from tbl_comment;

create view view_comment_member as
(
select m.member_name, m.member_grade, c.id, c.comment_content, c.post_id, c.member_id, c.created_date, c.updated_date, c.comment_status
from tbl_member m join tbl_comment c on m.id = c.member_id
    );

select * from view_comment_member;
