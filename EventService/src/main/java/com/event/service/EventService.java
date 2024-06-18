package com.event.service;

import java.util.List;

import com.event.model.Event;
import com.event.model.Ticket;

public interface EventService {
	Event createEvent(Event event);
    Event getEventById(Long id);
    List<Event> getAllEvents();
    Event updateEvent(Long id, Event eventDetails);
    void deleteEvent(Long id);
	List<Ticket> getTicketsForEvent(Long eventId);
	Ticket getTicketById(Long id);
	List<Ticket> getAllTickets();
}
