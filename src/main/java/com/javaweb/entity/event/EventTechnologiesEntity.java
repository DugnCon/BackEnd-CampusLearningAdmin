package com.javaweb.entity.event;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="eventtechnologies")
public class EventTechnologiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long TechID;
	@Column(name="Technology")
	private String technology;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="EventID")
	private EventEntity eventTechnology;
	public Long getTechID() {
		return TechID;
	}
	public void setTechID(Long techID) {
		TechID = techID;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public EventEntity getEvents() {
		return eventTechnology;
	}
	public void setEvents(EventEntity events) {
		this.eventTechnology = events;
	}
}
