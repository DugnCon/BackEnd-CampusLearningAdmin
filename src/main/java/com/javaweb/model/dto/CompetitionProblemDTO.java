package com.javaweb.model.dto;

import java.time.LocalDateTime;

public class CompetitionProblemDTO {
	private String title;
	private String description;
	private String difficulty;
	private Integer points;
	private Integer timeLimit;
	private Integer memoryLimit;
	private String inputFormat;
	private String outputFormat;
	private String constraints;
	private String sampleInput;
	private String sampleOutput;
	private String explanation;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String imageUrl;
	private String starterCode;
	private String testCasesVisible;
	private String testCasesHidden;
	private String tags;
	private String instructions;
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
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
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
	public String getInputFormat() {
		return inputFormat;
	}
	public void setInputFormat(String inputFormat) {
		this.inputFormat = inputFormat;
	}
	public String getOutputFormat() {
		return outputFormat;
	}
	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}
	public String getConstraints() {
		return constraints;
	}
	public void setConstraints(String constraints) {
		this.constraints = constraints;
	}
	public String getSampleInput() {
		return sampleInput;
	}
	public void setSampleInput(String sampleInput) {
		this.sampleInput = sampleInput;
	}
	public String getSampleOutput() {
		return sampleOutput;
	}
	public void setSampleOutput(String sampleOutput) {
		this.sampleOutput = sampleOutput;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getStarterCode() {
		return starterCode;
	}
	public void setStarterCode(String starterCode) {
		this.starterCode = starterCode;
	}
	public String getTestCasesVisible() {
		return testCasesVisible;
	}
	public void setTestCasesVisible(String testCasesVisible) {
		this.testCasesVisible = testCasesVisible;
	}
	public String getTestCasesHidden() {
		return testCasesHidden;
	}
	public void setTestCasesHidden(String testCasesHidden) {
		this.testCasesHidden = testCasesHidden;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
}
