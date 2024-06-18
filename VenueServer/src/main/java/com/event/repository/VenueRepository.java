package com.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.model.Venue;
@Repository
public interface VenueRepository  extends JpaRepository<Venue, Long>  {

}
