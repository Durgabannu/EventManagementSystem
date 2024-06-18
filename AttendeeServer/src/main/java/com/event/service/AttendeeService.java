package com.event.service;

import java.util.List;

import com.event.model.Attendee;
import com.event.model.Event;
import com.event.model.EventAnalytics;
import com.event.model.Ticket;
import com.event.model.Venue;

public interface AttendeeService {
	Attendee createAttendee(Attendee attendee);
    Attendee getAttendeeById(Long id);
    List<Attendee> getAttendeesByEventId(Long eventId);
    List<Attendee> getAllAttendees();
    Attendee updateAttendee(Long id, Attendee attendeeDetails);
    void deleteAttendee(Long id);
	Ticket getTicketById(Long id);
	List<Ticket> getTicketsByEventId(Long eventId);
	List<Ticket> getAllTickets();
	Venue getVenueById(Long id);
	List<Venue> getAllVenues();
	Event getEventById(Long id);
	List<Event> getAllEvents();
	List<EventAnalytics> getAllEventAnalytics();
	EventAnalytics getEventAnalyticsById(Long eventId);
	
}
