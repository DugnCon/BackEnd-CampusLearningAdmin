package com.javaweb.builder;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class UserBuilder {
	private Long UserID;
	private String username;
	private String email;
	private String fullName;
	private String dateOfBirth;
	private String school;
	private String role;
	private String status;
	private String accountStatus;
	private LocalDateTime createdAt;
	private LocalDateTime lastLoginAt;
	private Integer duration;
	private String reason;
	public UserBuilder() {
        // empty constructor for Spring
    }
	public UserBuilder(Builder builder) {
		this.UserID = builder.UserID;
		this.username = builder.username;
		this.email = builder.email;
		this.fullName = builder.fullName;
		this.dateOfBirth = builder.dateOfBirth;
		this.school = builder.school;
		this.role = builder.role;
		this.status = builder.status;
		this.accountStatus = builder.accountStatus;
		this.createdAt = builder.createdAt;
		this.lastLoginAt = builder.lastLoginAt;
		this.reason = builder.reason;
		this.duration = builder.duration;
	}
	public Integer getLockDuration() {
		return duration;
	}

	public String getLockReason() {
		return reason;
	}

	public Long getUserID() {
		return UserID;
	}
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getFullName() {
		return fullName;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getSchool() {
		return school;
	}

	public String getRole() {
		return role;
	}

	public String getStatus() {
		return status;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getLastLoginAt() {
		return lastLoginAt;
	}
	
	public static class Builder {
		private Long UserID;
		private String username;
		private String email;
		private String fullName;
		private String dateOfBirth;
		private String school;
		private String role;
		private String status;
		private String accountStatus;
		private LocalDateTime createdAt;
		private LocalDateTime lastLoginAt;
		private String reason;
		private Integer duration;
		public Builder setUserID(Long userID) {
			this.UserID = userID;
			return this;
		}
		public Builder setLockReason(String reason) {
			this.reason = reason;
			return this;
		}
		public Builder setLockDuration(Integer duration) {
			this.duration = duration;
			return this;
		}
		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		public Builder setFullName(String fullName) {
			this.fullName = fullName;
			return this;
		}
		public Builder setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}
		public Builder setSchool(String school) {
			this.school = school;
			return this;
		}
		public Builder setRole(String role) {
			this.role = role;
			return this;
		}
		public Builder setStatus(String status) {
			this.status = status;
			return this;
		}
		public Builder setAccountStatus(String accountStatus) {
			this.accountStatus = accountStatus;
			return this;
		}
		public Builder setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
			return this;
		}
		public Builder setLastLoginAt(LocalDateTime lastLoginAt) {
			this.lastLoginAt = lastLoginAt;
			return this;
		}
		public UserBuilder build() {
			return new UserBuilder(this);
		}
	}
}
