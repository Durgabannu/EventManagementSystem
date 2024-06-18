package com.event.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.event.model.Ticket;

@FeignClient(name = "ticket-service", url = "http://localhost:8081")
public interface TicketingClient {
	
	 @GetMapping("/ticket/{id}")
	    Ticket getTicketById(@PathVariable("id") Long id);

	    @GetMapping("/ticket/event/{eventId}")
	    List<Ticket> getTicketsByEventId(@PathVariable("eventId") Long eventId);

	    @GetMapping("/ticket/all")
	    List<Ticket> getAllTickets();
}
