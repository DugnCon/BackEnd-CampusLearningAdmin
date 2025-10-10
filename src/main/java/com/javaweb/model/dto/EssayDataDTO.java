package com.javaweb.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EssayDataDTO {
	private String content;
	private List<String> keywords;
	private Double minimumMatchPercentage;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	
}
