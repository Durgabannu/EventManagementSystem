package com.event.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.feignClient.EventClient;
import com.event.feignClient.VenueClient;
import com.event.model.Event;
import com.event.model.Speaker;
import com.event.model.Venue;
import com.event.repository.SpeakerRepository;

@Service
public class SpeakerServiceImpl implements SpeakerService {
   
	@Autowired
    private SpeakerRepository speakerRepository;
	
	@Autowired
    private EventClient eventClient;

    @Autowired
    private VenueClient venueClient;
    
    @Override
    public Speaker createSpeaker(Speaker speaker) {
        return speakerRepository.save(speaker);
    }

    @Override
    public Speaker getSpeakerById(Long id) {
        return speakerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Speaker> getAllSpeakers() {
        return speakerRepository.findAll();
    }

    @Override
    public List<Speaker> getSpeakersByScheduledTimeRange(LocalDateTime start, LocalDateTime end) {
        return speakerRepository.findByScheduledTimeBetween(start, end);
    }

    @Override
    public Speaker updateSpeaker(Long id, Speaker speakerDetails) {
        Speaker speaker = getSpeakerById(id);
        speaker.setName(speakerDetails.getName());
        speaker.setTopic(speakerDetails.getTopic());
        speaker.setScheduledTime(speakerDetails.getScheduledTime());
        return speakerRepository.save(speaker);
    }

    @Override
    public void deleteSpeaker(Long id) {
        Speaker speaker = getSpeakerById(id);
        speakerRepository.delete(speaker);
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
    public Venue getVenueById(Long id) {
        return venueClient.getVenueById(id);
    }

    @Override
    public List<Venue> getAllVenues() {
        return venueClient.getAllVenues();
    }
   
	
}
