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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
	private Integer content;
	@Column(name="OrderIndex")
	private Integer orderIndex;
	@Column(name="Options")
	private String options;
	@Column(name="CorrectAnswer")
	private String correctAnswer;
	@Column(name="Explaination")
	private String explaination;
	@Column(name="CreatedAt", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ExamID", nullable = false)
	private ExamsEntity exams;
	@OneToMany(mappedBy = "examTemplateQuestions", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ExamAnswerTemplatesEntity> examAnswerTemplate = new ArrayList<>();
	
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
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
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
