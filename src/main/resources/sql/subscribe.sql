-- auto-generated definition
create table tbl_subscribe
(
    id              bigint unsigned auto_increment
        primary key,
    subscribe_price int                                not null,
    created_date    datetime default CURRENT_TIMESTAMP null,
    updated_date    datetime default CURRENT_TIMESTAMP null
);
select * from tbl_subscribe;