drop table Company;

create table if not exists Company (
    id identity,
    name VARCHAR(50),
    city VARCHAR(50),
    street VARCHAR(50),
    house_Number VARCHAR(50),
    zip_Code VARCHAR(50)
    );