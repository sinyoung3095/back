create table tbl_notice
(
    id             bigint unsigned auto_increment
        primary key,
    notice_title   varchar(255)                       not null,
    notice_content varchar(255)                       not null,
    created_date   datetime default CURRENT_TIMESTAMP null,
    updated_date   datetime default CURRENT_TIMESTAMP null
);

select * from tbl_notice;

insert into tbl_notice (notice_title, notice_content)
values ('공지 제목9',
        '09공지 내용입니다. 공지 내용이 들어오는 공간입니다. 최대 2줄까지 출력됩니다.');