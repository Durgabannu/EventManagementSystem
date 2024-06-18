package com.event.controller;

import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.model.Event;
import com.event.model.Speaker;
import com.event.model.Venue;
import com.event.service.SpeakerService;

@RestController
@RequestMapping("/speakers")
public class SpeakerController {
	@Autowired
    private SpeakerService speakerService;

    @PostMapping("/add")
    public ResponseEntity<Speaker> createSpeaker(@RequestBody Speaker speaker) {
        return new ResponseEntity<>(speakerService.createSpeaker(speaker), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Speaker> getSpeakerById(@PathVariable Long id) {
        return new ResponseEntity<>(speakerService.getSpeakerById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Speaker>> getAllSpeakers() {
        return new ResponseEntity<>(speakerService.getAllSpeakers(), HttpStatus.OK);
    }

    @GetMapping("/schedule")
    public ResponseEntity<List<Speaker>> getSpeakersByScheduledTimeRange(
            @RequestParam("start") LocalDateTime start,
            @RequestParam("end") LocalDateTime end) {
        return new ResponseEntity<>(speakerService.getSpeakersByScheduledTimeRange(start, end), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Speaker> updateSpeaker(@PathVariable Long id, @RequestBody Speaker speakerDetails) {
        return new ResponseEntity<>(speakerService.updateSpeaker(id, speakerDetails), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpeaker(@PathVariable Long id) {
        speakerService.deleteSpeaker(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //eventservice
    @GetMapping("/getevent/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = speakerService.getEventById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping("/getevent/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = speakerService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    //venue service
    
    @GetMapping("/venues/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
        Venue venue = speakerService.getVenueById(id);
        return new ResponseEntity<>(venue, HttpStatus.OK);
    }

    @GetMapping("/venues/all")
    public ResponseEntity<List<Venue>> getAllVenues() {
        List<Venue> venues = speakerService.getAllVenues();
        return new ResponseEntity<>(venues, HttpStatus.OK);
    }

}
