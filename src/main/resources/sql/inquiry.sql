
create table tbl_inquiry
(
    id              bigint unsigned auto_increment
        primary key,
    inquiry_title   varchar(255)                       not null,
    inquiry_content varchar(255)                       not null,
    inquiry_email   varchar(255)                       not null,
    created_date    datetime default CURRENT_TIMESTAMP null,
    updated_date    datetime default CURRENT_TIMESTAMP null,
    member_id       bigint unsigned                    not null,
    constraint fk_inquiry_member
        foreign key (member_id) references tbl_member (id)
);

