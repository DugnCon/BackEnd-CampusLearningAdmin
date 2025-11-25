package com.javaweb.entity.Course;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="lessonprogress")
@DynamicUpdate
public class LessonProgressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ProgressID;
	//enrollmentId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LessonID")
	@JsonBackReference("lesson-progress")
	private CourseLessonsEntity lessons;
	//lessonId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="EnrollmentID")
	@JsonBackReference("enroll-progress")
	private CourseEnrollmentEntity enrollment;
	@Column(name="Status", length = 20)
	private String status;
	@Column(name="CompletedAt")
	private LocalDateTime completedAt;
	@Column(name="TimeSpent")
	private Integer timeSpent;
	@Column(name="LastPosition")
	private Integer lastPosition;
	
	public Long getProgressID() {
		return ProgressID;
	}
	public void setProgressID(Long progressID) {
		ProgressID = progressID;
	}
	public CourseLessonsEntity getLessons() {
		return lessons;
	}
	public void setLessons(CourseLessonsEntity lessons) {
		this.lessons = lessons;
	}
	public CourseEnrollmentEntity getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(CourseEnrollmentEntity enrollment) {
		this.enrollment = enrollment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCompletedAt() {
		return completedAt;
	}
	public void setCompletedAt(LocalDateTime completedAt) {
		this.completedAt = completedAt;
	}
	public Integer getTimeSpent() {
		return timeSpent;
	}
	public void setTimeSpent(Integer timeSpent) {
		this.timeSpent = timeSpent;
	}
	public Integer getLastPosition() {
		return lastPosition;
	}
	public void setLastPosition(Integer lastPosition) {
		this.lastPosition = lastPosition;
	}
	
}
