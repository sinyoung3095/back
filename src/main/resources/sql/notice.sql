
create table tbl_notice
(
    id             bigint unsigned auto_increment
        primary key,
    notice_title   varchar(255)                       not null,
    notice_content varchar(255)                       not null,
    created_date   datetime default CURRENT_TIMESTAMP null,
    updated_date   datetime default CURRENT_TIMESTAMP null
);

