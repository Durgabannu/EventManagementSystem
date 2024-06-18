package com.event.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Attendee")

public class Attendee {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private Long eventId;
	    private String name;
	    private String email;
	    private String phoneNumber;
	    private boolean isEngaged;
	    
	    
		public Attendee() {
			super();
		}

		public Attendee(Long id, Long eventId, String name, String email, String phoneNumber, boolean isEngaged) {
			super();
			this.id = id;
			this.eventId = eventId;
			this.name = name;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.isEngaged = isEngaged;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getEventId() {
			return eventId;
		}

		public void setEventId(Long eventId) {
			this.eventId = eventId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public boolean isEngaged() {
			return isEngaged;
		}

		public void setEngaged(boolean isEngaged) {
			this.isEngaged = isEngaged;
		}
		
		

	    
	    
	}

