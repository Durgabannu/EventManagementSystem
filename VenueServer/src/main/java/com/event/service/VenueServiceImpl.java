package com.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.event.FeignClient.AttendeeClient;
import com.event.FeignClient.EventAnalyticsClient;
import com.event.FeignClient.EventClient;
import com.event.FeignClient.SpeakerClient;
import com.event.FeignClient.TicketClient;
import com.event.model.Attendee;
import com.event.model.Event;
import com.event.model.EventAnalytics;
import com.event.model.Speaker;
import com.event.model.Ticket;
import com.event.model.Venue;
import com.event.repository.VenueRepository;

@Service
public class VenueServiceImpl implements VenueService {
	 @Autowired
	    private VenueRepository venueRepository;

	    @Autowired
	    private EventClient eventClient;

	    @Autowired
	    private TicketClient ticketClient;
	    @Autowired
	    private SpeakerClient speakerClient;
	    
	    @Autowired
	    private EventAnalyticsClient eventAnalyticsClient;

	    @Autowired
	    private AttendeeClient attendeeClient;

	    @Override
	    public Venue createVenue(Venue venue) {
	        return venueRepository.save(venue);
	    }

	    @Override
	    public Venue getVenueById(Long id) {
	        return venueRepository.findById(id).orElseThrow();
	    }

	    @Override
	    public List<Venue> getAllVenues() {
	        return venueRepository.findAll();
	    }

	    @Override
	    public Venue updateVenue(Long id, Venue venueDetails) {
	        Venue venue = getVenueById(id);
	        venue.setName(venueDetails.getName());
	        venue.setAddress(venueDetails.getAddress());
	        venue.setCapacity(venueDetails.getCapacity());
	        venue.setHasFoodService(venueDetails.isHasFoodService());
	        venue.setHasEntertainment(venueDetails.isHasEntertainment());
	        return venueRepository.save(venue);
	    }

	    @Override
	    public void deleteVenue(Long id) {
	        Venue venue = getVenueById(id);
	        venueRepository.delete(venue);
	    }
	    
	   //eventservice
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
	    
	    //ticketservice
	    @Override
	    public List<Ticket> getTicketsForEvent(Long eventId) {
	        return ticketClient.getTicketsByEventId(eventId);
	    }

	    @Override
	    public Ticket getTicketById(Long id) {
	        return ticketClient.getTicketById(id);
	    }

	    @Override
	    public List<Ticket> getAllTickets() {
	        return ticketClient.getAllTickets();
	    }
	    
	    //speakerService
	    @Override
	    public Speaker getSpeakerById(Long id) {
	        return speakerClient.getSpeakerById(id).getBody();
	    }

	    @Override
	    public List<Speaker> getAllSpeakers() {
	        return speakerClient.getAllSpeakers().getBody();
	    }

	    @Override
	    public List<Speaker> getSpeakersByScheduledTimeRange() {
	        return speakerClient.getSpeakersByScheduledTimeRange().getBody();
	    }
	    
	    //attendeeService
	    
	    @Override
	    public Attendee getAttendeeById(Long id) {
	        return attendeeClient.getAttendeeById(id);
	    }

	    @Override
	    public List<Attendee> getAttendeesByEventId(Long eventId) {
	        return attendeeClient.getAttendeesByEventId(eventId);
	    }

	    @Override
	    public List<Attendee> getAllAttendees() {
	        return attendeeClient.getAllAttendees();
	    }
	    
	    //eventAnalyticService
	    
	    @Override
	    public List<EventAnalytics> getAllEventAnalytics() {
	        return eventAnalyticsClient.getAllEventAnalytics();
	    }

	    @Override
	    public EventAnalytics getEventAnalyticsById(Long eventId) {
	        return eventAnalyticsClient.getEventAnalyticsById(eventId);
	    }
	

}
