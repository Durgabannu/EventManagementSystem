package com.event.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.event.model.Attendee;
import com.event.model.Event;
import com.event.model.EventAnalytics;
import com.event.model.Speaker;
import com.event.model.Ticket;
import com.event.model.Venue;

public interface VenueService {
	 Venue createVenue(Venue venue);
	    Venue getVenueById(Long id);
	    List<Venue> getAllVenues();
	    Venue updateVenue(Long id, Venue venueDetails);
	    void deleteVenue(Long id);
		ResponseEntity<Event> getEventById(Long id);
		ResponseEntity<List<Event>> getAllEvents();
		List<Ticket> getTicketsForEvent(Long eventId);
		Ticket getTicketById(Long id);
		List<Ticket> getAllTickets();
		Speaker getSpeakerById(Long id);
		List<Speaker> getAllSpeakers();
		List<Speaker> getSpeakersByScheduledTimeRange();
		Attendee getAttendeeById(Long id);
		List<Attendee> getAttendeesByEventId(Long eventId);
		List<Attendee> getAllAttendees();
		List<EventAnalytics> getAllEventAnalytics();
		EventAnalytics getEventAnalyticsById(Long eventId);
}
