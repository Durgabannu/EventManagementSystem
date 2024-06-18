package com.event.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.event.model.Event;
import com.event.model.Ticket;

public interface TicketService {
	Ticket createTicket(Ticket ticket);
    Ticket getTicketById(Long id);
    List<Ticket> getTicketsByEventId(Long eventId);
    List<Ticket> getAllTickets();
    Ticket updateTicket(Long id, Ticket ticketDetails);
    void deleteTicket(Long id);
	ResponseEntity<Event> getEventById(Long id);
	ResponseEntity<List<Event>> getAllEvents();
	
	
}
