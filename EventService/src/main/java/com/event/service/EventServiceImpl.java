package com.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.feignClient.TicketingClient;
import com.event.model.Event;
import com.event.model.Ticket;
import com.event.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private TicketingClient ticketingClient;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event updateEvent(Long id, Event eventDetails) {
        Event event = getEventById(id);
        event.setName(eventDetails.getName());
        event.setDescription(eventDetails.getDescription());
        event.setDate(eventDetails.getDate());
        event.setLocation(eventDetails.getLocation());
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
    }
    //ticketService
    @Override
    public List<Ticket> getTicketsForEvent(Long eventId) {
        return ticketingClient.getTicketsByEventId(eventId);
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketingClient.getTicketById(id);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketingClient.getAllTickets();
    }

}
