package com.javaweb.model.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * Dùng để lưu các object của các bài kiểm tra 
 * thay vì tạo nhiều lớp gây rối
 * **/
public class TypeOfExamsDTO {
	private Long QuestionID;
	private Long TemplateID;
	private Integer points;
	private Integer content;
	private Integer orderIndex;
	private List<String> options;
	private String correctAnswer;
	private String explaination;
	private List<String> keywords = new ArrayList<>();
	private Double minimumMatchPercentage;
	private Map<String, Object> essayData = new HashMap<>();
	public Long getTemplateID() {
		return TemplateID;
	}
	public void setTemplateID(Long templateID) {
		TemplateID = templateID;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public Double getMinimumMatchPercentage() {
		return minimumMatchPercentage;
	}
	public void setMinimumMatchPercentage(Double minimumMatchPercentage) {
		this.minimumMatchPercentage = minimumMatchPercentage;
	}
	public Map<String, Object> getEssayData() {
		return essayData;
	}
	public void setEssayData(Map<String, Object> essayData) {
		this.essayData = essayData;
	}
	public Long getQuestionID() {
		return QuestionID;
	}
	public void setQuestionID(Long questionID) {
		QuestionID = questionID;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Integer getContent() {
		return content;
	}
	public void setContent(Integer content) {
		this.content = content;
	}
	public Integer getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}
	
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getExplaination() {
		return explaination;
	}
	public void setExplaination(String explaination) {
		this.explaination = explaination;
	}
	
}
