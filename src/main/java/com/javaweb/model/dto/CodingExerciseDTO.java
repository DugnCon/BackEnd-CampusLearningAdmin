package com.javaweb.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class CodingExerciseDTO {
	private Long lessonId;
	private String title;
	private String description;
	private String programmingLanguage;
	private String initialCode;
	private String solutionCode;
	private List<TestCasesDTO> testCases;
	private Integer timeLimit;
	private Integer memoryLimit;
	private String difficulty;
	
	public Long getLessonId() {
		return lessonId;
	}
	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
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
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}
	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
	public String getInitialCode() {
		return initialCode;
	}
	public void setInitialCode(String initialCode) {
		this.initialCode = initialCode;
	}
	public String getSolutionCode() {
		return solutionCode;
	}
	public void setSolutionCode(String solutionCode) {
		this.solutionCode = solutionCode;
	}
	
	public List<TestCasesDTO> getTestCases() {
		return testCases;
	}
	public void setTestCases(List<TestCasesDTO> testCases) {
		this.testCases = testCases;
	}
	public Integer getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}
	public Integer getMemoryLimit() {
		return memoryLimit;
	}
	public void setMemoryLimit(Integer memoryLimit) {
		this.memoryLimit = memoryLimit;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
}
