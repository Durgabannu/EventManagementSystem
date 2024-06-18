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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.model.Attendee;
import com.event.model.Event;
import com.event.model.EventAnalytics;
import com.event.model.Ticket;
import com.event.model.Venue;
import com.event.service.AttendeeService;

@RestController
@RequestMapping("/attendee")

public class AttendeeController {
	
	@Autowired
    private AttendeeService attendeeService;

    @PostMapping("/add")
    public ResponseEntity<Attendee> createAttendee(@RequestBody Attendee attendee) {
        return new ResponseEntity<>(attendeeService.createAttendee(attendee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendee> getAttendeeById(@PathVariable Long id) {
        return new ResponseEntity<>(attendeeService.getAttendeeById(id), HttpStatus.OK);
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Attendee>> getAttendeesByEventId(@PathVariable Long eventId) {
        return new ResponseEntity<>(attendeeService.getAttendeesByEventId(eventId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Attendee>> getAllAttendees() {
        return new ResponseEntity<>(attendeeService.getAllAttendees(), HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Attendee> updateAttendee(@PathVariable Long id, @RequestBody Attendee attendeeDetails) {
        return new ResponseEntity<>(attendeeService.updateAttendee(id, attendeeDetails), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendee(@PathVariable Long id) {
        attendeeService.deleteAttendee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    //ticketservice 
    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = attendeeService.getTicketById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping("/ticket/event/{eventId}")
    public ResponseEntity<List<Ticket>> getTicketsByEventId(@PathVariable Long eventId) {
        List<Ticket> tickets = attendeeService.getTicketsByEventId(eventId);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/ticket/all")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = attendeeService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
    
    //venueService

    @GetMapping("/venues/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
        Venue venue = attendeeService.getVenueById(id);
        return new ResponseEntity<>(venue, HttpStatus.OK);
    }

    @GetMapping("/venues/all")
    public ResponseEntity<List<Venue>> getAllVenues() {
        List<Venue> venues = attendeeService.getAllVenues();
        return new ResponseEntity<>(venues, HttpStatus.OK);
    }

    //eventservice
    @GetMapping("/getevent/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = attendeeService.getEventById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping("/getevent/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = attendeeService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
 // Analytics-related endpoints

    @GetMapping("/analytics/event")
    public ResponseEntity<List<EventAnalytics>> getAllEventAnalytics() {
        List<EventAnalytics> eventAnalytics = attendeeService.getAllEventAnalytics();
        return new ResponseEntity<>(eventAnalytics, HttpStatus.OK);
    }

    @GetMapping("/analytics/event/{eventId}")
    public ResponseEntity<EventAnalytics> getEventAnalyticsById(@PathVariable Long eventId) {
        EventAnalytics eventAnalytics = attendeeService.getEventAnalyticsById(eventId);
        return new ResponseEntity<>(eventAnalytics, HttpStatus.OK);
    }
    

}
