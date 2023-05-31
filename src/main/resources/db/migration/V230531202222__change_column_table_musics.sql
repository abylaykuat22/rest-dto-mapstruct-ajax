alter table musics
drop column author,
add column author_id bigint,
add foreign key(author_id) references users(id)