do
$$
    begin
        if not exists (select from pg_type where typname = 'sex') then
            create type "sex" as enum ('MALE', 'FEMALE');
        end if;
    end;
$$

create table if not exists author(
    id varchar(50) primary key,
    name varchar(150)not null,
    sex char(1) check (sex in ('M', 'F'))
);

   