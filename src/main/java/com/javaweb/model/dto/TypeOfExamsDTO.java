package com.javaweb.model.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	private String content;
	private Integer orderIndex;
	private List<String> options;
	private String correctAnswer;
	private String explanation;
	public Long getTemplateID() {
		return TemplateID;
	}
	public void setTemplateID(Long templateID) {
		TemplateID = templateID;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
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
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	
	
}
