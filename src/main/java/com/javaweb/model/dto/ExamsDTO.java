package com.javaweb.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamsDTO {
	private Long ExamID;
	private Long courseID;
	private String courseTitle;
	private String title;
	private String description;
	private String type;
	private Integer duration;
	private Integer totalPoints;
	private Integer passingScore;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String instructions;
	private boolean allowReview;
	private boolean shuffleQuestions;
	
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public Long getCourseID() {
		return courseID;
	}
	public void setCourseID(Long courseID) {
		this.courseID = courseID;
	}
	public Long getExamID() {
		return ExamID;
	}
	public void setExamID(Long examID) {
		ExamID = examID;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(Integer totalPoints) {
		this.totalPoints = totalPoints;
	}
	public Integer getPassingScore() {
		return passingScore;
	}
	public void setPassingScore(Integer passingScore) {
		this.passingScore = passingScore;
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
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public boolean isAllowReview() {
		return allowReview;
	}
	public void setAllowReview(boolean allowReview) {
		this.allowReview = allowReview;
	}
	public boolean isShuffleQuestions() {
		return shuffleQuestions;
	}
	public void setShuffleQuestions(boolean shuffleQuestions) {
		this.shuffleQuestions = shuffleQuestions;
	}
	
}
