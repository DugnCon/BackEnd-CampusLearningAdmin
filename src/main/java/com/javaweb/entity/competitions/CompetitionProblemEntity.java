package com.javaweb.entity.competitions;

import java.time.LocalDateTime;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "competitionproblems")
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class CompetitionProblemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProblemID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CompetitionID", nullable = false)
    @JsonBackReference
    private CompetitionEntity competition;

    @Column(name = "Title", length = 200, nullable = false)
    private String title;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "Difficulty", length = 20)
    private String difficulty;

    @Column(name = "Points")
    private Integer points;

    @Column(name = "TimeLimit")
    private Integer timeLimit; // giây

    @Column(name = "MemoryLimit")
    private Integer memoryLimit; // MB

    @Column(name = "InputFormat", columnDefinition = "TEXT")
    private String inputFormat;

    @Column(name = "OutputFormat", columnDefinition = "TEXT")
    private String outputFormat;

    @Column(name = "Constraints", columnDefinition = "TEXT")
    private String constraints;

    @Column(name = "SampleInput", columnDefinition = "TEXT")
    private String sampleInput;

    @Column(name = "SampleOutput", columnDefinition = "TEXT")
    private String sampleOutput;

    @Column(name = "Explanation", columnDefinition = "TEXT")
    private String explanation;

    @CreationTimestamp
    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "ImageURL", length = 500)
    private String imageURL;

    @Column(name = "StarterCode", columnDefinition = "TEXT")
    private String starterCode;

    @Column(name = "TestCasesVisible", columnDefinition = "TEXT")
    private String testCasesVisible;

    @Column(name = "TestCasesHidden", columnDefinition = "TEXT")
    private String testCasesHidden;

    @Column(name = "Tags", length = 500)
    private String tags;

    @Column(name = "Instructions", columnDefinition = "TEXT")
    private String instructions;

    // ===== Getters & Setters =====
    

    public CompetitionEntity getCompetition() {
        return competition;
    }

    public Long getProblemID() {
		return ProblemID;
	}

	public void setProblemID(Long problemID) {
		ProblemID = problemID;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCompetition(CompetitionEntity competition) {
        this.competition = competition;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
