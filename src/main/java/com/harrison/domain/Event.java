package com.harrison.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "events")
public class Event implements Serializable {

	private static final long serialVersionUID = -1236516142120043487L;
	
	@Id
	@Column(name = "id")
	private long id;
	
	@NotNull
	@Column(name = "event_id")
	private String eventId;
	
	@Column(name = "esn")
	private String esn;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "event", optional = false)
	private EventUnitSource eventUnitSource;

	public Event() {
		//default constructor
	}

	public Event(long id, String eventId, String esn, EventUnitSource eventUnitSource) {
		this.id = id;
		this.eventId = eventId;
		this.esn = esn;
		this.eventUnitSource = eventUnitSource;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEsn() {
		return esn;
	}

	public void setEsn(String esn) {
		this.esn = esn;
	}

	public EventUnitSource getEventUnitSource() {
		return eventUnitSource;
	}

	public void setEventUnitSource(EventUnitSource eventUnitSource) {
		this.eventUnitSource = eventUnitSource;
	}
	
}
