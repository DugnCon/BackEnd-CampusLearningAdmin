package com.javaweb.model.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodingExercisesDTO {
	private Long ExerciseID;
	private String title;
	private String desciption;
	private String programming;
	private String initialCode;
	private String solutionCode;
	private Map<String, Object> codingExercise;
	public Long getExerciseID() {
		return ExerciseID;
	}
	public void setExerciseID(Long exerciseID) {
		ExerciseID = exerciseID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public String getProgramming() {
		return programming;
	}
	public void setProgramming(String programming) {
		this.programming = programming;
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
	public Map<String, Object> getCodingExercise() {
		return codingExercise;
	}
	public void setCodingExercise(Map<String, Object> codingExercise) {
		this.codingExercise = codingExercise;
	}
}
