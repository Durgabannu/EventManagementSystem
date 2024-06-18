package com.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.event.model.Event;
import com.event.model.Ticket;
import com.event.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
    private TicketService ticketService;
	
    @PostMapping("/purchase")
    public ResponseEntity<Ticket> purchaseTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.createTicket(ticket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        return new ResponseEntity<>(ticketService.getTicketById(id), HttpStatus.OK);
    }

    @GetMapping("/ticket/event/{eventId}")
    public ResponseEntity<List<Ticket>> getTicketsByEventId(@PathVariable Long eventId) {
        return new ResponseEntity<>(ticketService.getTicketsByEventId(eventId), HttpStatus.OK);
    }
    
    @GetMapping("/ticket/all")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return new ResponseEntity<>(ticketService.getAllTickets(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        return new ResponseEntity<>(ticketService.updateTicket(id, ticketDetails), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
   // to get event 
    
    @GetMapping("/getevent/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        ResponseEntity<Event> response = ticketService.getEventById(id);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(response.getBody());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getevent/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        ResponseEntity<List<Event>> response = ticketService.getAllEvents();
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(response.getBody());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    

}
