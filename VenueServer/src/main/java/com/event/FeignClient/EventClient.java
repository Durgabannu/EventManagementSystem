package com.event.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.event.model.Event;

@FeignClient(name = "event-service", url = "http://localhost:8080")
public interface EventClient {
	
	 @GetMapping("/getevent/{id}")
	    Event getEventById(@PathVariable Long id);

	    @GetMapping("/getevent/all")
	    List<Event> getAllEvents();
	}