
create table tbl_member
(
    id                       bigint unsigned auto_increment primary key,
    member_name              varchar(255)                                          not null,
    member_email             varchar(255)                                          null,
    kakao_email       varchar(255)                                          null,
    member_provider          enum ('kakao', 'rebound')   default 'rebound'         null,
    member_phone_number      bigint                                                not null,
    member_password          varchar(255)                                          null,
    member_suggestion_count  int unsigned                default '0'               null,
    kakao_profile_url varchar(255)                                          null,
    member_grade            enum ('mentor','subscribe', 'none')     default 'none'   null,
    member_status            enum ('active', 'inactive') default 'active'          null,
    member_common              enum ('admin', 'none')    default 'none'          null,
    created_date             datetime                    default CURRENT_TIMESTAMP null,
    updated_date             datetime                    default CURRENT_TIMESTAMP null,
    lately_date datetime,
    constraint member_email
        unique (member_email),
    constraint kakao_email
        unique (kakao_email),
    constraint member_phone_number
        unique (member_phone_number)
);