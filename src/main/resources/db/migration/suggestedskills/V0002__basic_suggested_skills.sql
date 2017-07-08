drop table if exists suggested_skill;

create type proficiency_enum as enum ('BEGINNER', 'INTERMEDIATE', 'ADVANCED', 'EXPERT');

create table suggested_skill (
  name varchar,
  years_of_experience numeric,
  proficiency proficiency_enum
);

insert into suggested_skill (name, years_of_experience, proficiency)
  values
  ('AI', 2, 'BEGINNER'),
  ('Flyway', 2, 'INTERMEDIATE'),
  ('Nginx', 2, 'INTERMEDIATE');
