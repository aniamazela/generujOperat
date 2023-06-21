drop table Company;
drop table Properties;

create table if not exists Company (
    id identity,
    name VARCHAR(50),
    city VARCHAR(50),
    street VARCHAR(50),
    house_Number VARCHAR(50),
    zip_Code VARCHAR(50)
    );

 create table if not exists Properties (
    id identity, 
    teryt VARCHAR(10), 
    voivodship VARCHAR(50),
    county VARCHAR(50), 
    gmina VARCHAR(50),
    guarter VARCHAR(50)
 );