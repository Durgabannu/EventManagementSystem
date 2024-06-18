package com.event.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "venue")

public class Venue {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private int capacity;
    private boolean hasFoodService;
    private boolean hasEntertainment;
    
    
	public Venue() {
		super();
	}


	public Venue(Long id, String name, String address, int capacity, boolean hasFoodService, boolean hasEntertainment) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.capacity = capacity;
		this.hasFoodService = hasFoodService;
		this.hasEntertainment = hasEntertainment;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public boolean isHasFoodService() {
		return hasFoodService;
	}


	public void setHasFoodService(boolean hasFoodService) {
		this.hasFoodService = hasFoodService;
	}


	public boolean isHasEntertainment() {
		return hasEntertainment;
	}


	public void setHasEntertainment(boolean hasEntertainment) {
		this.hasEntertainment = hasEntertainment;
	}
	
    
    

}
