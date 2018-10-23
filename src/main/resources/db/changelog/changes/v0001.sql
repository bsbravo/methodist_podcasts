create table Book (
  id bigserial not null,
  description varchar(512) not null,
  bookOrder integer,
  primary key (id)
);

create table Episode (
  id bigserial not null,
  title varchar(50) not null,
  description varchar(512) not null,
  url varchar(512) not null,
  author varchar(255),
  date timestamp,
  book bigint references Book(id),
  primary key (id)
);

create table CountPlays (
  idEpisode bigint not null primary key references Episode(id),
  count bigint
);
