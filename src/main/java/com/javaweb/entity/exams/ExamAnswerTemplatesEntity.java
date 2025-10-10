package com.javaweb.entity.exams;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="examanswertemplates")
@EntityListeners(AuditingEntityListener.class)
public class ExamAnswerTemplatesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long TemplateID;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ExamID")
	@JsonBackReference
	private ExamsEntity examTemplates;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="QuestionID")
	@JsonBackReference
	private ExamQuestionsEntity examTemplateQuestions;
	@Column(name="Content")
	private String content;
	@Column(name="Keywords")
	private String keywords;
	@Column(name="MinimumMatchPercentage")
	private Double minimumMatchPercentage;
	@Column(name="CreatedAt", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	
	public Long getTemplateID() {
		return TemplateID;
	}
	public void setTemplateID(Long templateID) {
		TemplateID = templateID;
	}
	public ExamsEntity getExamTemplates() {
		return examTemplates;
	}
	public void setExamTemplates(ExamsEntity examTemplates) {
		this.examTemplates = examTemplates;
	}
	public ExamQuestionsEntity getExamTemplateQuestions() {
		return examTemplateQuestions;
	}
	public void setExamTemplateQuestions(ExamQuestionsEntity examTemplateQuestions) {
		this.examTemplateQuestions = examTemplateQuestions;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Double getMinimumMatchPercentage() {
		return minimumMatchPercentage;
	}
	public void setMinimumMatchPercentage(Double minimumMatchPercentage) {
		this.minimumMatchPercentage = minimumMatchPercentage;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
