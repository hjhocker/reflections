package com.harrison.controllers;

import java.util.List;

import javax.transaction.Transactional;

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

	@Transactional
	private EventComponent save(EventComponent ec) {
		EventUnitSource eus = ec.getEventUnitSource();
		ec.setEventUnitSource(null);
		ec = eventComponentRepository.save(ec);
		eus.setEvent(ec);
		eus = eventUnitSourceRepository.save(eus);
		ec.setEventUnitSource(eus);
		return ec;
	}
	
}
