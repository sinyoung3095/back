create table tbl_counselor
(
    id                        bigint unsigned auto_increment primary key,
    counselor_name            varchar(255) not null,
    counselor_email           varchar(255) not null unique,
    counselor_phone_number    bigint not null unique,
    counselor_password        varchar(255),
    counselor_address         varchar(255),
    counselor_status          enum ('active', 'inactive') default 'active',
    counselor_approval_status enum ('approval', 'atmosphere', 'refusal') default 'atmosphere',
    counselor_license_name varchar(255),
    created_date              datetime default CURRENT_TIMESTAMP,
    updated_date              datetime default CURRENT_TIMESTAMP
);

select * from tbl_counselor;