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
values ('공지 제목07',
        '07공지 내용입니다. 이미지 위에 텍스트가 얹어집니다. 해당 내용은 테스트용으로, 후에 필요하시다면 지우셔도 됩니다.');