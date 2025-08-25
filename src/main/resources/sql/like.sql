create table tbl_like (
    id bigint unsigned auto_increment primary key,
    member_id    bigint unsigned                    not null,
    comment_id   bigint unsigned                    not null,
    created_date datetime default CURRENT_TIMESTAMP null,
    updated_date    datetime default CURRENT_TIMESTAMP null,
    constraint fk_like_member foreign key (member_id) references tbl_member(id),
    constraint fk_like_comment foreign key (comment_id) references tbl_comment(id)
);

select * from tbl_like;

alter table tbl_like
    add constraint uq_like unique (member_id, comment_id);
