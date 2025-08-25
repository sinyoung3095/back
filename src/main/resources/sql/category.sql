create table tbl_category(
    id bigint unsigned auto_increment primary key,
    category_name varchar(255),
    created_date datetime default current_timestamp(),
    updated_date datetime default current_timestamp()
);

select * from tbl_category;

insert into tbl_category(category_name)
values
    ('대인관계'),
    ('가족'),
    ('연애'),
    ('육아/출산'),
    ('신체건강'),
    ('정신건강'),
    ('금전/사업'),
    ('자아/성격'),
    ('취업/진로'),
    ('펫로스'),
    ('학업/고시');
