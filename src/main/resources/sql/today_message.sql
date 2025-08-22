
create table tbl_today_message
(
    id                    bigint unsigned auto_increment
        primary key,
    today_message_content varchar(255)                       not null,
    created_date          datetime default CURRENT_TIMESTAMP null,
    updated_date          datetime default CURRENT_TIMESTAMP null,
    counselor_id          bigint unsigned                    null,
    constraint fk_today_message_counselor
        foreign key (counselor_id) references tbl_counselor (id)
);

select * from tbl_today_message;
select * from tbl_counselor;

insert into tbl_today_message (today_message_content, counselor_id)
values ('4오늘의 좋은 말 내용입니다. 테스트용으로, 후에 삭제하셔도 무관합니다.', 6);