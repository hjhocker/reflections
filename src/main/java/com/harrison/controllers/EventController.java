package com.harrison.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrison.domain.EventComponent;
import com.harrison.domain.EventUnitSource;
import com.harrison.repository.EventComponentRepository;
import com.harrison.repository.EventUnitSourceRepository;

@RestController
@RequestMapping(value = "/")
public class EventController {
	
	@Autowired
	private EventComponentRepository eventComponentRepository;
	
	@Autowired
	private EventUnitSourceRepository eventUnitSourceRepository;
	
	@RequestMapping(value = "eventcomponents", method = RequestMethod.GET)
	public List<EventComponent> getEvents() {
		return eventComponentRepository.findAll();
	}
	
	@RequestMapping(value = "eventcomponent", method = RequestMethod.PUT)
	public EventComponent createEvent(@RequestBody EventComponent eventComponent) {
		return save(eventComponent);
	}
	
	@RequestMapping(value = "eventcomponent", method = RequestMethod.POST)
	public EventComponent updateEvent(@RequestBody EventComponent eventComponent) {
		throw new UnsupportedOperationException("You cannot change this table!");
	}
	
	@RequestMapping(value = "eventcomponent", method = RequestMethod.DELETE)
	public EventComponent deleteEvent(@RequestBody EventComponent eventComponent) {
		throw new UnsupportedOperationException("You cannot change this table!");
	}

	private EventComponent save(EventComponent ec) {
		EventUnitSource eus = ec.getEventUnitSource();
		ec.setEventUnitSource(null);
		ec = eventComponentRepository.save(ec);
		eus.setEvent(ec);
		try {
			eus = eventUnitSourceRepository.save(eus);
		} catch (Exception e) {
			eventComponentRepository.delete(ec);
			throw new RuntimeException(e);
		}
		ec.setEventUnitSource(eus);
		return ec;
	}
	
}
