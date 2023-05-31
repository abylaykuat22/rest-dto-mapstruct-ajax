create table if not exists users
(
    id bigserial not null
        constraint pk_users_id primary key,
    name varchar
)