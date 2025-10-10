package com.javaweb.entity.exams;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="examquestions")
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class ExamQuestionsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long QuestionID;
	@Column(name="Points")
	private Integer points;
	@Column(name="Content")
	private String content;
	@Column(name="Type")
	private String type;
	@Column(name="OrderIndex")
	private Integer orderIndex;
	@Column(name="Options")
	private String option;
	@Column(name="CorrectAnswer")
	private String correctAnswer;
	@Column(name="Explanation")
	private String explanation;
	@Column(name="CreatedAt", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(name="UpdatedAt")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ExamID", nullable = false)
	@JsonBackReference
	private ExamsEntity exams;
	@OneToMany(mappedBy = "examTemplateQuestions", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
	private List<ExamAnswerTemplatesEntity> examAnswerTemplate = new ArrayList<>();
	
	@Transient
	private Long templateId;
	
	public Long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<ExamAnswerTemplatesEntity> getExamAnswerTemplate() {
		return examAnswerTemplate;
	}
	public void setExamAnswerTemplate(List<ExamAnswerTemplatesEntity> examAnswerTemplate) {
		this.examAnswerTemplate = examAnswerTemplate;
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
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
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
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public ExamsEntity getExams() {
		return exams;
	}
	public void setExams(ExamsEntity exams) {
		this.exams = exams;
	}
}
