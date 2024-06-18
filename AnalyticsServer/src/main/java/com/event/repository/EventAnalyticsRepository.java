package com.event.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.model.EventAnalytics;
@Repository
public interface EventAnalyticsRepository extends JpaRepository<EventAnalytics, Long> {

}
