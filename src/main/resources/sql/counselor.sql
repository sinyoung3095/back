
create table tbl_counselor
(
    id                        bigint unsigned auto_increment
        primary key,
    counselor_name            varchar(255)                                                         not null,
    counselor_email           varchar(255)                                                         not null,
    counselor_phone_number    bigint                                                               not null,
    counselor_password        varchar(255)                                                         not null,
    counselor_address         varchar(255)                                                         not null,
    counselor_status          enum ('active', 'inactive')                default 'active'          null,
    counselor_approval_status enum ('approval', 'atmosphere', 'refusal') default 'atmosphere'      null,
    created_date              datetime                                   default CURRENT_TIMESTAMP null,
    updated_date              datetime                                   default CURRENT_TIMESTAMP null,
    file_id                   bigint unsigned                                                      not null,
    constraint counselor_email
        unique (counselor_email),
    constraint counselor_phone_number
        unique (counselor_phone_number),
    constraint fk_counselor_file
        foreign key (file_id) references tbl_file (id)
);


alter table tbl_counselor modify counselor_approval_status enum ('approval', 'await', 'refusal') default 'await';

