
create table tbl_payment
(
    id                  bigint unsigned auto_increment
        primary key,
    created_date        datetime default CURRENT_TIMESTAMP null,
    updated_date        datetime default CURRENT_TIMESTAMP null,
    payment_start_date  datetime default CURRENT_TIMESTAMP null,
    payment_update_date datetime default CURRENT_TIMESTAMP null,
    subscribe_id        bigint unsigned                    null,
    member_id           bigint unsigned                    null,
    constraint fk_payment_member
        foreign key (member_id) references tbl_member (id),
    constraint fk_payment_subscribe
        foreign key (subscribe_id) references tbl_subscribe (id)
);

