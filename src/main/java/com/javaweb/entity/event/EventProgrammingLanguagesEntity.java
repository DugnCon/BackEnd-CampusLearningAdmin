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
@Table(name="eventprogramminglanguages")
public class EventProgrammingLanguagesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long LanguageID;
	@Column(name="Language")
	private String language;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="EventID")
	@JsonBackReference
	private EventEntity eventLanguage;
	
	public EventEntity getEventLanguage() {
		return eventLanguage;
	}
	public void setEventLanguage(EventEntity eventLanguage) {
		this.eventLanguage = eventLanguage;
	}
	public Long getLanguageID() {
		return LanguageID;
	}
	public void setLanguageID(Long languageID) {
		LanguageID = languageID;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public EventEntity getEvents() {
		return eventLanguage;
	}
	public void setEvents(EventEntity eventLanguage) {
		this.eventLanguage = eventLanguage;
	}
}
