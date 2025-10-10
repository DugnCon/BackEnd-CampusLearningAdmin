package com.javaweb.entity.event;

import java.time.LocalDateTime;

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
import com.javaweb.entity.user.UserEntity;

@Entity
@Table(name="eventparticipants")
public class EventParticipantsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ParticipantID", nullable = false, updatable = false)
    private Long participantID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EventID", nullable = false)
    @JsonBackReference
    private EventEntity eventParticipant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="UserID", nullable = false)
    @JsonBackReference
    private UserEntity users;

    public UserEntity getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users = users;
    }

    /**
     * Sau update thêm UserID nữa
     * **/


    @Column(name = "RegistrationDate", nullable = false)
    private LocalDateTime registrationDate;

    @Column(name = "Status", length = 20)
    private String status;

    @Column(name = "TeamName", length = 100)
    private String teamName;

    @Column(name = "PaymentStatus", length = 20)
    private String paymentStatus;

    @Column(name = "AttendanceStatus", length = 20)
    private String attendanceStatus;

    public EventParticipantsEntity() {}

    // Getters and Setters
    public Long getParticipantID() {
        return participantID;
    }

    public void setParticipantID(Long participantID) {
        this.participantID = participantID;
    }

    public EventEntity getEventParticipant() {
		return eventParticipant;
	}

	public void setEventParticipant(EventEntity eventParticipant) {
		this.eventParticipant = eventParticipant;
	}

	public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }
}
