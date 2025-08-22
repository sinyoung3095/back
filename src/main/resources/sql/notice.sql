
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
values ('공지 제목10',
        '공지 내용10입니다. 리바운드에서 게시하는 공지의 내용이 들어오는 자리이며, 테스트용이므로 후에 지우셔도 무관합니다.');