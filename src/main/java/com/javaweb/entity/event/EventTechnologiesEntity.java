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

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@JsonBackReference
	private EventEntity eventTechnology;
	
	public EventEntity getEventTechnology() {
		return eventTechnology;
	}
	public void setEventTechnology(EventEntity eventTechnology) {
		this.eventTechnology = eventTechnology;
	}
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
}
