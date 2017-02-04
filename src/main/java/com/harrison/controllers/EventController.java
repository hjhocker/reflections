package com.harrison.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrison.domain.Event;
import com.harrison.repository.EventRepository;

@RestController
@RequestMapping(value = "/")
public class EventController {
	
	@Autowired
	private EventRepository eventRepository;
	
	@RequestMapping(value = "events", method = RequestMethod.GET)
	public List<Event> getEvents() {
		return eventRepository.findAll();
	}

}
