package com.javaweb.entity.event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="events")
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EventID;

    @Column(name="Title")
    private String title;

    @Column(name="Description")
    private String description;

    @Column(name="Category")
    private String category;

    @Column(name="EventDate")
    private LocalDate eventDate;

    @Column(name="EventTime")
    private LocalTime eventTime;

    @Column(name="Location")
    private String location;

    @Column(name="ImageUrl")
    private String imageUrl;

    @Column(name="MaxAttendees")
    private Integer maxAttendees;

    @Column(name="CurrentAttendees")
    private Integer currentAttendees;

    @Column(name="Price")
    private Double price;

    @Column(name="Organizer")
    private String organizer;

    @Column(name="Difficulty")
    private String difficulty;

    @Column(name="Status")
    private String status;

    @Column(name="CreatedAt")
    private LocalDateTime createdAt;

    @Column(name="UpdatedAt")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "eventTechnology", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<EventTechnologiesEntity> eventTechnologies = new HashSet<>();

    @OneToMany(mappedBy = "eventLanguage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<EventProgrammingLanguagesEntity> eventProgrammingLanguages = new HashSet<>();

    @OneToMany(mappedBy = "eventSchedule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<EventScheduleEntity> eventSchedules = new HashSet<>();

    @OneToMany(mappedBy = "eventPrize", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<EventPrizesEntity> eventPrizes = new HashSet<>();
    
    @OneToMany(mappedBy = "eventParticipant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<EventParticipantsEntity> eventParticipants = new HashSet<>();
    

    // ===== GETTERS & SETTERS =====
    
    
    public Set<EventTechnologiesEntity> getEventTechnologies() {
        return eventTechnologies;
    }


	public Set<EventParticipantsEntity> getEventParticipants() {
		return eventParticipants;
	}



	public void setEventParticipants(Set<EventParticipantsEntity> eventParticipants) {
		this.eventParticipants = eventParticipants;
	}



	public void setEventTechnologies(Set<EventTechnologiesEntity> eventTechnologies) {
        this.eventTechnologies = eventTechnologies;
    }

    public Set<EventProgrammingLanguagesEntity> getEventProgrammingLanguages() {
        return eventProgrammingLanguages;
    }

    public void setEventProgrammingLanguages(Set<EventProgrammingLanguagesEntity> eventProgrammingLanguages) {
        this.eventProgrammingLanguages = eventProgrammingLanguages;
    }

    public Set<EventScheduleEntity> getEventSchedules() {
		return eventSchedules;
	}

	public void setEventSchedules(Set<EventScheduleEntity> eventSchedules) {
		this.eventSchedules = eventSchedules;
	}

	public Set<EventPrizesEntity> getEventPrizes() {
        return eventPrizes;
    }

    public void setEventPrizes(Set<EventPrizesEntity> eventPrizes) {
        this.eventPrizes = eventPrizes;
    }

    public Long getEventID() {
        return EventID;
    }

    public void setEventID(Long eventID) {
        EventID = eventID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMaxAttendees() {
        return maxAttendees;
    }

    public void setMaxAttendees(Integer maxAttendees) {
        this.maxAttendees = maxAttendees;
    }

    public Integer getCurrentAttendees() {
        return currentAttendees;
    }

    public void setCurrentAttendees(Integer currentAttendees) {
        this.currentAttendees = currentAttendees;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
