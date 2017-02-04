package com.harrison.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	private static final String ALPHA = "ALPHA";

	private static final String CHARLIE = "CHARLIE";

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
	
	@RequestMapping(value = "event/{id}/sources")
	public Map<String, List<String>> getSources(@PathVariable(value = "id") String id) {
		Map<String, List<String>> map = new HashMap<>();
		List<EventComponent> components = eventComponentRepository.findByEventId(id);
		List<String> charlieIds = components.stream()
									.filter(c -> c.getEventUnitSource().getSourceName().equals(CHARLIE))
									.map(c -> c.getEventUnitSource().getSourceId())
									.collect(Collectors.toList());
		List<String> alphaIds = components.stream()
									.filter(c -> c.getEventUnitSource().getSourceName().equals(ALPHA))
									.map(c -> c.getEventUnitSource().getSourceId())
									.collect(Collectors.toList());
		map.put(CHARLIE, charlieIds);
		map.put(ALPHA, alphaIds);
		return map;
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
