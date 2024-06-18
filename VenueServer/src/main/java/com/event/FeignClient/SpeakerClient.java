package com.event.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.event.model.Speaker;
@FeignClient(name = "speaker-service", url = "http://localhost:8083")  

public interface SpeakerClient {

		@GetMapping("/speakers/{id}")
	    public ResponseEntity<Speaker> getSpeakerById(@PathVariable Long id) ;

	    @GetMapping("/speakers/all")
	    public ResponseEntity<List<Speaker>> getAllSpeakers() ;

	    @GetMapping("/speakers/schedule")
	    public ResponseEntity<List<Speaker>> getSpeakersByScheduledTimeRange();
	}

