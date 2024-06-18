package com.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.feignClient.AnalyticClient;
import com.event.feignClient.EventClient;
import com.event.feignClient.TicketClient;
import com.event.feignClient.VenueClient;
import com.event.model.Attendee;
import com.event.model.Event;
import com.event.model.EventAnalytics;
import com.event.model.Ticket;
import com.event.model.Venue;
import com.event.repository.AttendeeRepository;

@Service
public class AttendeeServiceImpl implements AttendeeService {
    @Autowired
    private AttendeeRepository attendeeRepository;
    
    @Autowired
    private EventClient eventClient;

    @Autowired
    private TicketClient ticketingClient;

    @Autowired
    private VenueClient venueClient;

    @Autowired
    private AnalyticClient analyticClient;
    
    @Override
    public Attendee createAttendee(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }

    @Override
    public Attendee getAttendeeById(Long id) {
        return attendeeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Attendee> getAttendeesByEventId(Long eventId) {
        return attendeeRepository.findByEventId(eventId);
    }

    @Override
    public List<Attendee> getAllAttendees() {
        return attendeeRepository.findAll();
    }

    @Override
    public Attendee updateAttendee(Long id, Attendee attendeeDetails) {
        Attendee attendee = getAttendeeById(id);
        attendee.setName(attendeeDetails.getName());
        attendee.setEmail(attendeeDetails.getEmail());
        attendee.setPhoneNumber(attendeeDetails.getPhoneNumber());
        attendee.setEngaged(attendeeDetails.isEngaged());
        return attendeeRepository.save(attendee);
    }

    @Override
    public void deleteAttendee(Long id) {
        Attendee attendee = getAttendeeById(id);
        attendeeRepository.delete(attendee);
    }
   
    @Override
    public Event getEventById(Long id) {
        return eventClient.getEventById(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventClient.getAllEvents();
    }
    
    @Override
    public Ticket getTicketById(Long id) {
        return ticketingClient.getTicketById(id);
    }

    @Override
    public List<Ticket> getTicketsByEventId(Long eventId) {
        return ticketingClient.getTicketsByEventId(eventId);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketingClient.getAllTickets();
    }

    @Override
    public Venue getVenueById(Long id) {
        return venueClient.getVenueById(id);
    }

    @Override
    public List<Venue> getAllVenues() {
        return venueClient.getAllVenues();
    }
    
    @Override
    public List<EventAnalytics> getAllEventAnalytics() {
        return analyticClient.getAllEventAnalytics();
    }

    @Override
    public EventAnalytics getEventAnalyticsById(Long eventId) {
        return analyticClient.getEventAnalyticsById(eventId);
    }

}
