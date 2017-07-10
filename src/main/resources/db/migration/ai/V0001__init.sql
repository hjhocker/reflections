drop table if exists iris;
drop type if exists species_enum;

create type species_enum as enum ('setosa', 'versicolor', 'virginica');

create table iris (
  id bigserial,
  sepal_length numeric,
  sepal_width numeric,
  petal_length numeric,
  petal_width numeric,
  species species_enum
);
