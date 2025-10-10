package com.javaweb.entity.user;

import java.time.LocalDateTime;
import java.util.HashSet;

import javax.persistence.*;
import java.util.*;
import com.javaweb.entity.event.EventParticipantsEntity;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="users")
@DynamicUpdate
//@EntityListeners(AuditingEntityListener.class)
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long UserID;
	@Column(name="Username")
	private String username;
	@Column(name="Password")
	private String password;
	@Column(name="Email")
	private String email;
	@Column(name="FullName")
	private String fullName;
	@Column(name="DateOfBirth")
	private String dateOfBirth;
	@Column(name="School")
	private String school;
	@Column(name="Role")
	private String role;
	@Column(name="Status")
	private String status;
	@Column(name="AccountStatus")
	private String accountStatus;
	@Column(name="CreatedAt")
	private LocalDateTime createdAt;
	@Column(name="LastLoginAt")
	private LocalDateTime lastLoginAt;
	@Column(name="LockDuration")
	private Integer lockDuration;
	@Column(name="LockReason")
	private String lockReason;
	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<EventParticipantsEntity> eventParticipants = new HashSet<>();

	public Set<EventParticipantsEntity> getEventParticipants() {
		return eventParticipants;
	}
	public void setEventParticipants(Set<EventParticipantsEntity> eventParticipants) {
		this.eventParticipants = eventParticipants;
	}
	public Integer getLockDuration() {
		return lockDuration;
	}
	public void setLockDuration(Integer lockDuration) {
		this.lockDuration = lockDuration;
	}
	public String getLockReason() {
		return lockReason;
	}
	public void setLockReason(String lockReason) {
		this.lockReason = lockReason;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getUserID() {
		return UserID;
	}
	public void setUserID(Long userID) {
		UserID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getLastLoginAt() {
		return lastLoginAt;
	}
	public void setLastLoginAt(LocalDateTime lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}
	
}
