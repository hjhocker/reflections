package com.harrison.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harrison.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	List<Event> findAll();

}
