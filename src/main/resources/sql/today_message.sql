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

insert into tbl_today_message (today_message_content, counselor_id)
values ('03오늘의 좋은 말 예시입니다. 테스트용으로, 메인페이지에는 회원일 경우 12개, 아닐 경우에는 3개만 보이도록 되어있습니다.',
        '3');
