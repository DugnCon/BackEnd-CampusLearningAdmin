package com.javaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@NamedStoredProcedureQuery (
		name = "AdminEntity.adminLogin",
		procedureName = "admin_login",
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "u_identifier", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "u_id", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "u_username_", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "u_email_", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "u_password", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "u_role", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "u_result", type = String.class)
		}
)
@Entity
@Table(name="users")
public class AdminEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long UserID;
	@Column(name="Username", nullable = false)
	private String username;
	@Column(name="Email", nullable = false)
	private String email;
	@Column(name="Password", nullable = false)
	private String password;
	@Column(name="FullName", nullable = false)
	private String fullname;
	@Column(name="DateOfBirth", nullable = false)
	private String dateOfBirth;
	@Column(name="School", nullable = false)
	private String school;
	@Column(name="Role", nullable = false)
	private String Role;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	
}
