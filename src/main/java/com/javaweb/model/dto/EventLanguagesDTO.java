package com.javaweb.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class EventLanguagesDTO {
	private Long EventID;
	public EventLanguagesDTO() {
		
	}
	
	public Long getEventID() {
		return EventID;
	}

	public void setEventID(Long eventID) {
		EventID = eventID;
	}

	private String language;
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	
}
