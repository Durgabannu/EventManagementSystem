package com.event.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.event.model.Venue;

@FeignClient(name = "venue-server", url = "http://localhost:8082")

public interface VenueClient {
	@GetMapping("/venues/{id}")
	Venue getVenueById(@PathVariable Long id);
	
    @GetMapping("/venues/all")
    List<Venue> getAllVenues();

}
