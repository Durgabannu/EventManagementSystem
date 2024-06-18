package com.event.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.event.model.EventAnalytics;
@FeignClient(name = "Analtics-server", url = "http://localhost:8085")  

public interface AnalyticClient {
		@GetMapping("/analytics/event")
	    public List<EventAnalytics> getAllEventAnalytics();

	    @GetMapping("/analytics/event/{eventId}")
	    public EventAnalytics getEventAnalyticsById(@PathVariable Long eventId);
	}

