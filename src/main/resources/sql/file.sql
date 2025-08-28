create table tbl_file
(
    id           bigint unsigned auto_increment
        primary key,
    file_path    varchar(255)                       not null,
    file_name    varchar(255)                       not null,
    file_size    int      default 0                 null,
    file_original_name varchar(255) not null,
    file_content_type varchar(255) not null,
    created_date datetime default CURRENT_TIMESTAMP null,
    updated_date datetime default CURRENT_TIMESTAMP null
);


select * from tbl_file;