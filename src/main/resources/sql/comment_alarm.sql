create table tbl_comment_alarm
(
    id           bigint unsigned auto_increment
        primary key,
    created_date datetime default CURRENT_TIMESTAMP null,
    updated_date datetime default CURRENT_TIMESTAMP null,
    member_id    bigint unsigned                    not null,
    comment_id   bigint unsigned                    not null,
    constraint fk_comment_alarm_comment
        foreign key (comment_id) references tbl_comment (id),
    constraint fk_comment_alarm_member
        foreign key (member_id) references tbl_member (id)
);

select * from tbl_comment_alarm;
