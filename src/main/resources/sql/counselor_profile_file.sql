
create table tbl_counselor_profile_file
(
    id           bigint unsigned not null
        primary key,
    counselor_id bigint unsigned not null,
    constraint fk_counselor_profile_file_counselor
        foreign key (counselor_id) references tbl_counselor (id),
    constraint fk_counselor_profile_file_file
        foreign key (id) references tbl_file (id)
);

select * from tbl_counselor_qualifications_file;