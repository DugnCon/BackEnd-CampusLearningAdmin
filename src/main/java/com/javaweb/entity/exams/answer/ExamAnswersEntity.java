package com.javaweb.entity.exams.answer;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.javaweb.entity.exams.ExamQuestionsEntity;

@Entity
@Table(name="examanswers")
public class ExamAnswersEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long AnswerID;
	/**
	 * Còn ParticipantID nữa để nào làm user-app thì sẽ update
	 * **/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="QuestionID")
	private ExamQuestionsEntity examQuestions;
	@Column(name="Answer")
	private String answer;
	@Column(name="IsCorrect")
	private boolean isCorrect;
	@Column(name="Score")
	private Integer score;
	@Column(name="ReviewerComments")
	private String reviewerComments;
	@Column(name="SubmittedAt")
	private LocalDateTime submittedAt;
	public Long getAnswerID() {
		return AnswerID;
	}
	public void setAnswerID(Long answerID) {
		AnswerID = answerID;
	}
	public ExamQuestionsEntity getExamQuestions() {
		return examQuestions;
	}
	public void setExamQuestions(ExamQuestionsEntity examQuestions) {
		this.examQuestions = examQuestions;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getReviewerComments() {
		return reviewerComments;
	}
	public void setReviewerComments(String reviewerComments) {
		this.reviewerComments = reviewerComments;
	}
	public LocalDateTime getSubmittedAt() {
		return submittedAt;
	}
	public void setSubmittedAt(LocalDateTime submittedAt) {
		this.submittedAt = submittedAt;
	}
	
}
