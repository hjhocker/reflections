create table event_components (
  id bigserial primary key,
  event_id varchar not null,
  is_planning boolean default false,
  esn varchar,

  constraint unique_eventId_esn_isPlanning_constraint
    unique (event_id, esn, is_planning)
);

create sequence event_id_sequence start 1;

create table event_unit_sources (
  id bigserial primary key,
  source_name varchar CHECK (upper(source_name) = source_name),
  source_id varchar,
  event_component_id bigint not null references event_components(id),

  constraint unique_sourceName_sourceId_eventComponentId_constraint
    unique (source_id, source_name, event_component_id),

  constraint unique_sourceName_sourceId_constraint
    unique (source_id, source_name)
);

ALTER TABLE event_unit_sources
   ADD CONSTRAINT sourceName_is_charlie_or_alpha_constraint
   CHECK (source_name IN ('ALPHA', 'CHARLIE'));

CREATE OR REPLACE FUNCTION fv_is_alpha_ok_to_insert(event_component_id bigint) returns boolean as
$$
 select count(ec.event_id) = 0 from event_unit_sources eus
   join event_components ec on eus.event_component_id = ec.id
   where ec.id = event_component_id
   and eus.source_name = 'ALPHA';
$$ LANGUAGE 'sql';

alter table event_unit_sources
  add constraint fv_is_alpha_ok_to_insert_constraint CHECK
  (fv_is_alpha_ok_to_insert(event_component_id))
