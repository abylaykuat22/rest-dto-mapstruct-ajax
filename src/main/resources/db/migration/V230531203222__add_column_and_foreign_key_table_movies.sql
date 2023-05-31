alter table movies
add column main_actor_id bigint,
add foreign key(main_actor_id) references users(id)