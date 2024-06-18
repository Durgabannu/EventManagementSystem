package com.event.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Speaker {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String topic;
	    private LocalDateTime scheduledTime;
	    
	    
		public Speaker() {
			super();
		}


		public Speaker(Long id, String name, String topic, LocalDateTime scheduledTime) {
			super();
			this.id = id;
			this.name = name;
			this.topic = topic;
			this.scheduledTime = scheduledTime;
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


		public String getTopic() {
			return topic;
		}


		public void setTopic(String topic) {
			this.topic = topic;
		}


		public LocalDateTime getScheduledTime() {
			return scheduledTime;
		}


		public void setScheduledTime(LocalDateTime scheduledTime) {
			this.scheduledTime = scheduledTime;
		}
	    
		
	    


}
