create table if not exists musics
(
    id bigserial not null
        constraint pk_musics_id primary key,
    name varchar
);

create table if not exists sports
(
    id bigserial not null
        constraint pk_sports_id primary key,
    name varchar,
    description text
)