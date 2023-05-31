create table if not exists movies
(
    id bigserial not null
        constraint pk_movies_id primary key,
    name varchar(50),
    description text,
    rating float,
    amount_view int,
    promo_code varchar
)