package com.harrison.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "event_unit_sources")
public class EventUnitSource implements Serializable {

	private static final long serialVersionUID = 3225553595128126839L;

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "source_name")
	private String sourceName;
	
	@Column(name = "source_id")
	private String sourceId;

	@JsonIgnore
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "event_primary_key", unique = true, nullable = false, updatable = false)
	public Event event;

	public EventUnitSource() {
		//default constructor
	}
	
	public EventUnitSource(long id, String sourceName, String sourceId, Event event) {
		this.id = id;
		this.sourceName = sourceName;
		this.sourceId = sourceId;
		this.event = event;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	
}
