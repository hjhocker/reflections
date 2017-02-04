create table event_components (
  id bigserial primary key,
  event_id varchar not null,
  esn varchar,
  constraint unique_event_esn_combination_constraint
    unique (event_id, esn)
);

create sequence event_id_sequence start 1;

create table event_unit_sources (
  id bigserial primary key,
  source_name varchar CHECK (upper(source_name) = source_name),
  source_id varchar,
  event_component_primary_key bigint not null references event_components(id),
  constraint unique_sourceName_sourceId_eventComponentPrimaryKey_constraint
    unique (source_id, source_name, event_component_primary_key),
  constraint unique_sourceName_sourceId_constraint
    unique (source_id, source_name)
);

ALTER TABLE event_unit_sources
   ADD CONSTRAINT sourceName_is_charlie_or_alpha_constraint
   CHECK (upper(source_name) IN ('ALPHA', 'CHARLIE'));
