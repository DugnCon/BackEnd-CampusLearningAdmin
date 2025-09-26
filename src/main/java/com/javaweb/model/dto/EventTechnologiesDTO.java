package com.javaweb.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class EventTechnologiesDTO {
	public EventTechnologiesDTO() {}
	private String technology;
	private Long EventID;
	
	public Long getEventID() {
		return EventID;
	}

	public void setEventID(Long eventID) {
		EventID = eventID;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

}
