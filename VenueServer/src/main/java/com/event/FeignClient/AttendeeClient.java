package com.event.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.event.model.Attendee;
@FeignClient(name = "Attendee-server", url = "http://localhost:8084")  

public interface AttendeeClient {

	 @GetMapping("/attendee/{id}")
	    public Attendee getAttendeeById(@PathVariable Long id);
	    @GetMapping("/attendee/event/{eventId}")
	    public List<Attendee> getAttendeesByEventId(@PathVariable Long eventId);
	    @GetMapping("/attendee/all")
	    public List<Attendee> getAllAttendees() ;
	    

	    
}
