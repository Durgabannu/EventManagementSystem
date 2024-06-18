package com.event.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.feignClient.AttendeeClient;
import com.event.feignClient.EventClient;
import com.event.feignClient.TicketClient;
import com.event.feignClient.VenueClient;
import com.event.model.Attendee;
import com.event.model.Event;
import com.event.model.EventAnalytics;
import com.event.model.Ticket;
import com.event.model.Venue;
import com.event.repository.EventAnalyticsRepository;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {
   
	 @Autowired
	    private EventAnalyticsRepository eventAnalyticsRepository;

	 @Autowired
	    private AttendeeClient attendeeServiceClient;

	    @Autowired
	    private EventClient eventServiceClient;

	    @Autowired
	    private TicketClient ticketServiceClient;

	    @Autowired
	    private VenueClient venueServiceClient;
	    
	 @Autowired
	    public void EventAnalyticsServiceImpl(EventAnalyticsRepository eventAnalyticsRepository) {
	        this.eventAnalyticsRepository = eventAnalyticsRepository;
	    }

	    @Override
	    public EventAnalytics createEventAnalytics(EventAnalytics eventAnalytics) {
	        return eventAnalyticsRepository.save(eventAnalytics);
	    }

	    @Override
	    public List<EventAnalytics> getAllEventAnalytics() {
	        return eventAnalyticsRepository.findAll();
	    }

	    @Override
	    public Optional<EventAnalytics> getEventAnalyticsById(Long eventId) {
	        return eventAnalyticsRepository.findById(eventId);
	    }

	    @Override
	    public EventAnalytics updateEventAnalytics(Long eventId, EventAnalytics updatedEventAnalytics) {
	        EventAnalytics existingEventAnalytics = eventAnalyticsRepository.findById(eventId)
	                .orElseThrow(() -> new RuntimeException("Event Analytics not found with id " + eventId));

	        existingEventAnalytics.setEventName(updatedEventAnalytics.getEventName());
	        existingEventAnalytics.setEngagedAttendees(updatedEventAnalytics.getEngagedAttendees());
	        existingEventAnalytics.setTotalAttendees(updatedEventAnalytics.getTotalAttendees());

	        return eventAnalyticsRepository.save(existingEventAnalytics);
	    }

	    @Override
	    public void deleteEventAnalytics(Long eventId) {
	        eventAnalyticsRepository.deleteById(eventId);
	    }

	    @Override
	    public Attendee getAttendeeById(Long id) {
	        return attendeeServiceClient.getAttendeeById(id);
	    }

	    @Override
	    public List<Attendee> getAttendeesByEventId(Long eventId) {
	        return attendeeServiceClient.getAttendeesByEventId(eventId);
	    }

	    @Override
	    public List<Attendee> getAllAttendees() {
	        return attendeeServiceClient.getAllAttendees();
	    }

	    @Override
	    public Event getEventById(Long id) {
	        return eventServiceClient.getEventById(id);
	    }

	    @Override
	    public List<Event> getAllEvents() {
	        return eventServiceClient.getAllEvents();
	    }

	    @Override
	    public Ticket getTicketById(Long id) {
	        return ticketServiceClient.getTicketById(id);
	    }

	    @Override
	    public List<Ticket> getTicketsByEventId(Long eventId) {
	        return ticketServiceClient.getTicketsByEventId(eventId);
	    }

	    @Override
	    public List<Ticket> getAllTickets() {
	        return ticketServiceClient.getAllTickets();
	    }

	    @Override
	    public Venue getVenueById(Long id) {
	        return venueServiceClient.getVenueById(id);
	    }

	    @Override
	    public List<Venue> getAllVenues() {
	        return venueServiceClient.getAllVenues();
	    }
}
