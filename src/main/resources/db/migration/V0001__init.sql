create table event_components (
  id bigserial primary key,
  event_id varchar not null,
  is_planning boolean default false,
  esn varchar,

  -- The combination of Event ID, ESN and Is Planning is unique
  -- This allows for a Charlie and Alpha component to be added
  -- to the same event but both reference the same ESN
  constraint unique_eventId_esn_isPlanning_constraint
    unique (event_id, esn, is_planning)
);

--Used to create Event IDs when creating new events
create sequence event_id_sequence start 1;

create table event_unit_sources (
  id bigserial primary key,
  source_name varchar CHECK (upper(source_name) = source_name), -- only uppercase allowed
  source_id varchar,
  event_component_id bigint not null references event_components(id),

  -- Source ID, Source Name and Event Component ID must be unique
  -- This prevents one event_unit_source from being mapped to
  -- multiple events
  constraint unique_sourceName_sourceId_eventComponentId_constraint
    unique (source_id, source_name, event_component_id),

  -- Source ID and Source Name can only be entered once so only 1 copy of each
  constraint unique_sourceName_sourceId_constraint
    unique (source_id, source_name)
);

-- Only allow for Alpha and Charlie components of events
ALTER TABLE event_unit_sources
   ADD CONSTRAINT sourceName_is_charlie_or_alpha_constraint
   CHECK (source_name IN ('ALPHA', 'CHARLIE'));

-- Only allow 1 Alpha component per Event. Makes the
-- unique_eventId_esn_isPlanning_constraint constraint
-- from just adding tons of Alpha components to an event
CREATE OR REPLACE FUNCTION fv_is_alpha_ok_to_insert(event_component_id bigint)
  returns boolean as
$$
 select count(ec.event_id) = 0 from event_unit_sources eus
   join event_components ec on eus.event_component_id = ec.id
   where ec.id = event_component_id
   and eus.source_name = 'ALPHA';
$$ LANGUAGE 'sql';

alter table event_unit_sources
  add constraint fv_is_alpha_ok_to_insert_constraint
  CHECK (fv_is_alpha_ok_to_insert(event_component_id));
