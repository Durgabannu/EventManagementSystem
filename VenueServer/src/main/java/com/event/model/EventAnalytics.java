package com.event.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EventAnalytics")

public class EventAnalytics {
		 @Id
		 @GeneratedValue(strategy = GenerationType.IDENTITY)
	       
		    private Long eventId;
		    private String eventName;
		    private int totalAttendees;
		    private int engagedAttendees;
		    
			public EventAnalytics() {
				super();
			}
			public EventAnalytics(Long eventId, String eventName, int totalAttendees, int engagedAttendees) {
				super();
				this.eventId = eventId;
				this.eventName = eventName;
				this.totalAttendees = totalAttendees;
				this.engagedAttendees = engagedAttendees;
			}
			public Long getEventId() {
				return eventId;
			}
			public void setEventId(Long eventId) {
				this.eventId = eventId;
			}
			public String getEventName() {
				return eventName;
			}
			public void setEventName(String eventName) {
				this.eventName = eventName;
			}
			public int getTotalAttendees() {
				return totalAttendees;
			}
			public void setTotalAttendees(int totalAttendees) {
				this.totalAttendees = totalAttendees;
			}
			public int getEngagedAttendees() {
				return engagedAttendees;
			}
			public void setEngagedAttendees(int engagedAttendees) {
				this.engagedAttendees = engagedAttendees;
			}
			
		
			
			
		    
		    
	

}
