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
import com.event.model.Speaker;
import com.event.model.Ticket;
import com.event.model.Venue;
import com.event.service.VenueService;

@RestController
@RequestMapping("/venues")
public class VenueController {
	@Autowired
    private VenueService venueService;

    @PostMapping("/add")
    public ResponseEntity<Venue> createVenue(@RequestBody Venue venue) {
        return new ResponseEntity<>(venueService.createVenue(venue), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
        return new ResponseEntity<>(venueService.getVenueById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Venue>> getAllVenues() {
        return new ResponseEntity<>(venueService.getAllVenues(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venue> updateVenue(@PathVariable Long id, @RequestBody Venue venueDetails) {
        return new ResponseEntity<>(venueService.updateVenue(id, venueDetails), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenue(@PathVariable Long id) {
        venueService.deleteVenue(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    // Event service endpoints
    @GetMapping("/getevent/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return venueService.getEventById(id);
    }

    @GetMapping("/getevent/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        return venueService.getAllEvents();
    }

    // Ticket service endpoints
    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = venueService.getTicketById(id);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/ticket/event/{eventId}")
    public ResponseEntity<List<Ticket>> getTicketsForEvent(@PathVariable Long eventId) {
        List<Ticket> tickets = venueService.getTicketsForEvent(eventId);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/ticket/all")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = venueService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    // Speaker service endpoints
    @GetMapping("/speakers/{id}")
    public ResponseEntity<Speaker> getSpeakerById(@PathVariable Long id) {
        Speaker speaker = venueService.getSpeakerById(id);
        return ResponseEntity.ok(speaker);
    }

    @GetMapping("/speakers/all")
    public ResponseEntity<List<Speaker>> getAllSpeakers() {
        List<Speaker> speakers = venueService.getAllSpeakers();
        return ResponseEntity.ok(speakers);
    }

    @GetMapping("/speakers/scheduled")
    public ResponseEntity<List<Speaker>> getSpeakersByScheduledTimeRange() {
        List<Speaker> speakers = venueService.getSpeakersByScheduledTimeRange();
        return ResponseEntity.ok(speakers);
    }

    // Attendee service endpoints
    @GetMapping("/attendee/{id}")
    public ResponseEntity<Attendee> getAttendeeById(@PathVariable Long id) {
        Attendee attendee = venueService.getAttendeeById(id);
        return ResponseEntity.ok(attendee);
    }

    @GetMapping("/attendee/event/{eventId}")
    public ResponseEntity<List<Attendee>> getAttendeesByEventId(@PathVariable Long eventId) {
        List<Attendee> attendees = venueService.getAttendeesByEventId(eventId);
        return ResponseEntity.ok(attendees);
    }

    @GetMapping("/attendee/all")
    public ResponseEntity<List<Attendee>> getAllAttendees() {
        List<Attendee> attendees = venueService.getAllAttendees();
        return ResponseEntity.ok(attendees);
    }

    // Event analytics service endpoints
    @GetMapping("/analytics/event")
    public ResponseEntity<List<EventAnalytics>> getAllEventAnalytics() {
        List<EventAnalytics> analytics = venueService.getAllEventAnalytics();
        return ResponseEntity.ok(analytics);
    }

    @GetMapping("/analytics/event/{eventId}")
    public ResponseEntity<EventAnalytics> getEventAnalyticsById(@PathVariable Long eventId) {
        EventAnalytics analytics = venueService.getEventAnalyticsById(eventId);
        return ResponseEntity.ok(analytics);
    }

}
