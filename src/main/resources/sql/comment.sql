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

select * from tbl_comment;
select * from tbl_comment where likes_count = 1;
alter table tbl_comment add column(likes_count int default 0);


create view view_comment_member as
(
select m.member_name, m.member_mentor, c.id, c.comment_content, c.post_id, c.member_id, c.created_date, c.updated_date, c.comment_status
from tbl_member m join tbl_comment c on m.id = c.member_id
    );

select * from view_comment_member;


insert into tbl_comment(comment_content,post_id,member_id)
values ("댓글 2",30,122);

drop view view_comment_member;

select * from tbl_comment
where post_id = 219;

