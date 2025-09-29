package com.javaweb.entity.event;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="eventschedule")
public class EventScheduleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ScheduleID;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="EventID")
	@JsonBackReference
	private EventEntity eventSchedule;
	@Column(name="ActivityName")
	private String activityName;
	@Column(name="StartTime")
	private LocalDateTime startTime;
	@Column(name="EndTime")
	private LocalDateTime endTime;
	@Column(name="Description")
	private String description;
	@Column(name="Location")
	private String location;
	@Column(name="Type")
	private String type;
	public Long getScheduleID() {
		return ScheduleID;
	}
	public void setScheduleID(Long scheduleID) {
		ScheduleID = scheduleID;
	}
	public EventEntity getEventSchedule() {
		return eventSchedule;
	}
	public void setEventSchedule(EventEntity eventSchedule) {
		this.eventSchedule = eventSchedule;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
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
