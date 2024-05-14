create table metric (
    id serial primary key,
    time_m timestamp,
    name varchar(100),
    value_m bigint
);