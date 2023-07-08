drop table if exists Properties CASCADE;
drop table if exists Companies CASCADE;


create table if not exists Companies (
    id bigint not null,
    name VARCHAR(50),
    city VARCHAR(50),
    street VARCHAR(50),
    house_Number VARCHAR(50),
    zip_Code VARCHAR(50),
    primary key (id)
    );

 create table if not exists Properties (
    id bigint not null,
    teryt VARCHAR(10), 
    voivodship VARCHAR(50),
    county VARCHAR(50), 
    gmina VARCHAR(50),
    guarter VARCHAR(50)
 );

 create table if not exists geodetic_works (
   id bigint not null,
   startDate DATE,
   finishDate DATE,
   company_id bigint not null,
   primary key (id)
 );

 alter table geodetic_works
   add foreign key (company_id)
   references Companies (id)