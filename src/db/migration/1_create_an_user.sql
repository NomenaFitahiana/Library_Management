do 
$$
    begin
        if not exists (
            select 1 from pg_roles where rlname = 'nomena'
        ) then
            create user "nomena" with password 'library';
        end if;

        grant select on all tables in schema public to "nomena";
        grant insert, update, delet on all table in schema public to "nomena";
    end;
$$