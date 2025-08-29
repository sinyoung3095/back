create table tbl_counselor
(
    id                        bigint unsigned auto_increment primary key,
    counselor_name            varchar(255) not null,
    counselor_email           varchar(255) not null unique,
    counselor_phone_number    bigint not null unique,
    counselor_password        varchar(255),
    counselor_address         varchar(255),
    counselor_status          enum ('active', 'inactive') default 'active',
    counselor_approval_status enum ('approval', 'await', 'refusal') default 'await',
    counselor_license_name varchar(255),
    lately_date datetime,
    created_date              datetime default CURRENT_TIMESTAMP,
    updated_date              datetime default CURRENT_TIMESTAMP
);
alter table tbl_counselor modify counselor_approval_status enum ('approval', 'await', 'refusal') default 'await';

insert into tbl_counselor (counselor_name, counselor_email, counselor_phone_number, counselor_password, counselor_address)
values ('상담사이름8', 'test8@gmail.com', '063448456789',
        '1234', '서울특별시 강남구 역삼로7길');

select * from tbl_counselor;
alter table tbl_counselor add lately_date datetime;
alter table tbl_counselor modify counselor_password varchar(255);
alter table tbl_counselor modify counselor_address varchar(255);
