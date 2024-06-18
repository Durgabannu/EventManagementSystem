package com.event.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.event.feignClient.EventClient;
import com.event.model.Event;
import com.event.model.Ticket;
import com.event.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
	 
	@Autowired
    private TicketRepository ticketRepository;

	 @Autowired
	    private EventClient eventClient;
    
	@Override
	public Ticket createTicket(Ticket ticket) {
	    ticket.setPurchaseDate(LocalDateTime.now());
	    return ticketRepository.save(ticket);
	}
   

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Ticket> getTicketsByEventId(Long eventId) {
        return ticketRepository.findByEventId(eventId);
    }
    
    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        Ticket ticket = getTicketById(id);
        ticket.setAttendeeName(ticketDetails.getAttendeeName());
        ticket.setAttendeePhoneNumber(ticketDetails.getAttendeePhoneNumber());
        ticket.setPaid(ticketDetails.isPaid());
        ticket.setPrice(ticketDetails.getPrice());
        ticket.setPurchaseDate(ticketDetails.getPurchaseDate());
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        Ticket ticket = getTicketById(id);
        ticketRepository.delete(ticket);
    }
    
    @Override
    public ResponseEntity<Event> getEventById(Long id) {
        Event event = eventClient.getEventById(id);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventClient.getAllEvents();
        return ResponseEntity.ok(events);
    }
    
    
}

   

