package com.javaweb.model.dto;

import java.time.LocalDateTime;

public class EventScheduleDTO {
	private Long ScheduleID;
	private String activityName;
	private LocalDateTime endTime;
	private LocalDateTime startTime;
	private String description;
	private String location;
	private String type;

	public Long getScheduleID() {
		return ScheduleID;
	}
	public void setScheduleID(Long scheduleID) {
		ScheduleID = scheduleID;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
