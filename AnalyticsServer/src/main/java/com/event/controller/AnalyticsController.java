package com.event.controller;

import java.util.List;
import java.util.Optional;

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
import com.event.service.AnalyticsService;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {
	
	 @Autowired
	    private AnalyticsService analyticsService;

	 @Autowired
	    public void EventAnalyticsController(AnalyticsService eventAnalyticsService) {
	        this.analyticsService = eventAnalyticsService;
	    }

	    @PostMapping("/add")
	    public ResponseEntity<EventAnalytics> createEventAnalytics(@RequestBody EventAnalytics eventAnalytics) {
	        EventAnalytics createdEventAnalytics = analyticsService.createEventAnalytics(eventAnalytics);
	        return ResponseEntity.ok(createdEventAnalytics);
	    }

	    @GetMapping("/event")
	    public ResponseEntity<List<EventAnalytics>> getAllEventAnalytics() {
	        List<EventAnalytics> allEventAnalytics = analyticsService.getAllEventAnalytics();
	        return ResponseEntity.ok(allEventAnalytics);
	    }

	    @GetMapping("/event/{eventId}")
	    public ResponseEntity<EventAnalytics> getEventAnalyticsById(@PathVariable Long eventId) {
	        Optional<EventAnalytics> eventAnalytics =analyticsService.getEventAnalyticsById(eventId);
	        return eventAnalytics.map(ResponseEntity::ok)
	                             .orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/event/{eventId}")
	    public ResponseEntity<EventAnalytics> updateEventAnalytics(
	            @PathVariable Long eventId,
	            @RequestBody EventAnalytics updatedEventAnalytics) {
	        EventAnalytics updatedAnalytics = analyticsService.updateEventAnalytics(eventId, updatedEventAnalytics);
	        return ResponseEntity.ok(updatedAnalytics);
	    }

	    @DeleteMapping("/event/{eventId}")
	    public ResponseEntity<Void> deleteEventAnalytics(@PathVariable Long eventId) {
	        analyticsService.deleteEventAnalytics(eventId);
	        return ResponseEntity.noContent().build();
	    }

	    //attendee service 
	    @GetMapping("/attendee/{id}")
	    public ResponseEntity<Attendee> getAttendeeById(@PathVariable Long id) {
	        Attendee attendee = analyticsService.getAttendeeById(id);
	        return new ResponseEntity<>(attendee, HttpStatus.OK);
	    }

	    @GetMapping("/attendee/event/{eventId}")
	    public ResponseEntity<List<Attendee>> getAttendeesByEventId(@PathVariable Long eventId) {
	        List<Attendee> attendees = analyticsService.getAttendeesByEventId(eventId);
	        return new ResponseEntity<>(attendees, HttpStatus.OK);
	    }

	    @GetMapping("/attendee/all")
	    public ResponseEntity<List<Attendee>> getAllAttendees() {
	        List<Attendee> attendees = analyticsService.getAllAttendees();
	        return new ResponseEntity<>(attendees, HttpStatus.OK);
	    }

	    //event service
	    @GetMapping("/getevent/{id}")
	    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
	        Event event = analyticsService.getEventById(id);
	        return new ResponseEntity<>(event, HttpStatus.OK);
	    }

	    @GetMapping("/getevent/all")
	    public ResponseEntity<List<Event>> getAllEvents() {
	        List<Event> events = analyticsService.getAllEvents();
	        return new ResponseEntity<>(events, HttpStatus.OK);
	    }

	    //ticketservice
	    @GetMapping("/ticket/{id}")
	    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
	        Ticket ticket = analyticsService.getTicketById(id);
	        return new ResponseEntity<>(ticket, HttpStatus.OK);
	    }

	    @GetMapping("/ticket/event/{eventId}")
	    public ResponseEntity<List<Ticket>> getTicketsByEventId(@PathVariable Long eventId) {
	        List<Ticket> tickets = analyticsService.getTicketsByEventId(eventId);
	        return new ResponseEntity<>(tickets, HttpStatus.OK);
	    }

	    @GetMapping("/ticket/all")
	    public ResponseEntity<List<Ticket>> getAllTickets() {
	        List<Ticket> tickets = analyticsService.getAllTickets();
	        return new ResponseEntity<>(tickets, HttpStatus.OK);
	    }
	    
	    //venueservice
	    @GetMapping("/venues/{id}")
	    public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
	        Venue venue = analyticsService.getVenueById(id);
	        return new ResponseEntity<>(venue, HttpStatus.OK);
	    }

	    @GetMapping("/venues/all")
	    public ResponseEntity<List<Venue>> getAllVenues() {
	        List<Venue> venues = analyticsService.getAllVenues();
	        return new ResponseEntity<>(venues, HttpStatus.OK);
	    }
}
