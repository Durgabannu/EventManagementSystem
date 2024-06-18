package com.event.service;

import java.time.LocalDateTime;
import java.util.List;
import com.event.model.Event;
import com.event.model.Speaker;
import com.event.model.Venue;

public interface SpeakerService {
	Speaker createSpeaker(Speaker speaker);
    Speaker getSpeakerById(Long id);
    List<Speaker> getAllSpeakers();
    List<Speaker> getSpeakersByScheduledTimeRange(LocalDateTime start, LocalDateTime end);
    Speaker updateSpeaker(Long id, Speaker speakerDetails);
    void deleteSpeaker(Long id);
	Event getEventById(Long id);
	List<Event> getAllEvents();
	Venue getVenueById(Long id);
	List<Venue> getAllVenues();
	
}
