package com.javaweb.entity.exams;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import com.javaweb.entity.Course.CourseEntity;
@Entity
@Table(name = "exams")
@DynamicUpdate
public class ExamsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ExamID;
    @Column(name="Title")
    private String title;
    @Column(name="Description")
    private String description;
    @Column(name="Type")
    private String type;
    @Column(name="Duration")
    private Integer duration;
    @Column(name="TotalPoints")
    private Integer totalPoints;
    @Column(name="PassingScore")
    private Integer passingScore;
    @Column(name="StartTime")
    private LocalDateTime startTime;
    @Column(name="EndTime")
    private LocalDateTime endTime;
    @Column(name="Instructions")
    private String instructions;
    @Column(name="Status")
    private String status;
    @Column(name="AllowReview")
    private boolean allowReview;
    @Column(name="ShuffleQuestions")
    private boolean shuffleQuestions;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CourseID", nullable = false)
    private CourseEntity courseExams;
    @OneToMany(mappedBy = "exams", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ExamQuestionsEntity> questions = new ArrayList<>();
    @OneToMany(mappedBy = "examTemplates", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ExamAnswerTemplatesEntity> examAnswerTemplates = new ArrayList<>();
    
    public List<ExamAnswerTemplatesEntity> getExamAnswerTemplates() {
		return examAnswerTemplates;
	}
	public void setExamAnswerTemplates(List<ExamAnswerTemplatesEntity> examAnswerTemplates) {
		this.examAnswerTemplates = examAnswerTemplates;
	}
	public boolean isAllowReview() {
		return allowReview;
	}
	public void setAllowReview(boolean allowReview) {
		this.allowReview = allowReview;
	}
	public boolean isShuffleQuestions() {
		return shuffleQuestions;
	}
	public void setShuffleQuestions(boolean shuffleQuestions) {
		this.shuffleQuestions = shuffleQuestions;
	}
	public Long getExamID() {
		return ExamID;
	}
	public void setExamID(Long examID) {
		ExamID = examID;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(Integer totalPoints) {
		this.totalPoints = totalPoints;
	}
	public Integer getPassingScore() {
		return passingScore;
	}
	public void setPassingScore(Integer passingScore) {
		this.passingScore = passingScore;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CourseEntity getCourseExams() {
		return courseExams;
	}
	public void setCourseExams(CourseEntity courseExams) {
		this.courseExams = courseExams;
	}
	public List<ExamQuestionsEntity> getQuestions() {
		return questions;
	}
	public void setQuestions(List<ExamQuestionsEntity> questions) {
		this.questions = questions;
	}
    
}
