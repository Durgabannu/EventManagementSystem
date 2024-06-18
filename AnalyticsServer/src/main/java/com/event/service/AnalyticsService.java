package com.event.service;

import java.util.List;
import java.util.Optional;

import com.event.model.Attendee;
import com.event.model.Event;
import com.event.model.EventAnalytics;
import com.event.model.Ticket;
import com.event.model.Venue;

public interface AnalyticsService {
	 EventAnalytics createEventAnalytics(EventAnalytics eventAnalytics);

	    List<EventAnalytics> getAllEventAnalytics();

	    Optional<EventAnalytics> getEventAnalyticsById(Long eventId);

	    EventAnalytics updateEventAnalytics(Long eventId, EventAnalytics updatedEventAnalytics);

	    void deleteEventAnalytics(Long eventId);


		List<Attendee> getAttendeesByEventId(Long eventId);

		List<Attendee> getAllAttendees();

		Event getEventById(Long id);

		List<Event> getAllEvents();

		Ticket getTicketById(Long id);

		List<Ticket> getTicketsByEventId(Long eventId);

		List<Ticket> getAllTickets();

		Venue getVenueById(Long id);

		List<Venue> getAllVenues();

		Attendee getAttendeeById(Long id);
}
