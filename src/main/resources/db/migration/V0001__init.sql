create table events (
  id bigserial primary key,
  event_id varchar not null,
  esn varchar,
  constraint unique_event_esn_combination unique (event_id, esn)
);

create sequence event_id_sequence start 1;

create table event_unit_sources (
  id bigserial primary key,
  source_name varchar CHECK (upper(source_name) = source_name),
  source_id varchar,
  event_primary_key bigint not null references events(id),
  constraint unique_sourceName_sourceId_eventPrimaryKey unique (source_id, source_name, event_primary_key),
  constraint unique_sourceName_sourceId unique (source_id, source_name)
);

UPDATE event_unit_sources SET source_name=upper(source_name);

ALTER TABLE event_unit_sources
   ADD CONSTRAINT sourceName_is_charlie_or_alpha_constraint
   CHECK (upper(source_name) IN ('ALPHA', 'CHARLIE'));
