do
$$
    begin   
        if not exists (select
         from pg_type where typname = 'topic') then
            create type "topic" as enum ('ROMANCE', 'COMEDY', 'OTHER');
        end if;
    end;
$$

create table if not exists books (
    id serial primary key,
    bookName varchar(50) not null,
    pageNumbers int not null,
    topic varchar(50) check (topic in ('ROMANCE', 'COMEDY', 'OTHER'))not null,
    releaseDate date not null,
    authorId varchar(50) references author ("id")
);