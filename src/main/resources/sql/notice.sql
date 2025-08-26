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

insert into tbl_notice(notice_title,notice_content)
values ("제목10","내용10");

create  view notice_view as (
select n.id, notice_title, notice_content, n.created_date, n.updated_date, notice_id, file_path, file_name, file_size
from tbl_notice n
join tbl_notice_file nf
on n.id = nf.notice_id
join tbl_file f on f.id=nf.id);

select  * from notice_view;

