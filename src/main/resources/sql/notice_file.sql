create table tbl_notice_file
(
    id        bigint unsigned not null
        primary key,
    notice_id bigint unsigned null,
    constraint fk_notice_file_file
        foreign key (id) references tbl_file (id),
    constraint fk_notice_file_notice
        foreign key (notice_id) references tbl_notice (id)
);

select * from tbl_notice_file;

