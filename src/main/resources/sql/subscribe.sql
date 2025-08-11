-- auto-generated definition
create table tbl_subscribe
(
    id              bigint unsigned auto_increment
        primary key,
    subscribe_price int                                not null,
    subscribe_boon  varchar(255)                       not null,
    created_date    datetime default CURRENT_TIMESTAMP null,
    updated_date    datetime default CURRENT_TIMESTAMP null
);
