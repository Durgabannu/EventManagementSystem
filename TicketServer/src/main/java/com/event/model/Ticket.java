package com.event.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Long eventId;
    private String attendeeName;
    private String attendeePhoneNumber;
    private boolean isPaid;
    private double price;
    private LocalDateTime purchaseDate;
    
    
	public Ticket() {
		super();
	}

	public Ticket(Long id, Long eventId, String attendeeName, String attendeePhoneNumber, boolean isPaid, double price,
			LocalDateTime purchaseDate) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.attendeeName = attendeeName;
		this.attendeePhoneNumber = attendeePhoneNumber;
		this.isPaid = isPaid;
		this.price = price;
		this.purchaseDate = purchaseDate;
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

	public String getAttendeeName() {
		return attendeeName;
	}

	public void setAttendeeName(String attendeeName) {
		this.attendeeName = attendeeName;
	}

	public String getAttendeePhoneNumber() {
		return attendeePhoneNumber;
	}

	public void setAttendeePhoneNumber(String attendeePhoneNumber) {
		this.attendeePhoneNumber = attendeePhoneNumber;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	
	
    
    
}
