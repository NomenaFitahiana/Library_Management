-- CREATE AN USER WITH ROLE

create user "nomena" with password 'library';

grant all privileges on database librarymanagement to nomena;

-- CREATE THE TABLE AUTHOR
create table author(
    id varchar(50) primary key,
    name varchar(150)not null,
    sex char(1) check (sex in ('M', 'F'))
);

-- CREATE THE TABLE BOOKS
create table books (
    id serial primary key,
    bookName varchar(50) not null,
    pageNumbers int not null,
    topic varchar(50) chekc (topic in "ROMANCE", "COMEDY", "OTHER")not null,
    releaseDate date,not null
    authorId varchar(50) references author ("id")
);