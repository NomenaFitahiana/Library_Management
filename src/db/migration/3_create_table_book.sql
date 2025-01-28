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
    book_name varchar(50) not null,
    page_numbers int not null,
    topic topic,
    release_date date not null,
    author_id varchar(50) references author ("id")
);