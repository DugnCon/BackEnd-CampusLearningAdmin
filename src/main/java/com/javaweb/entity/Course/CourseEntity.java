package com.javaweb.entity.Course;

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
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/*@NamedStoredProcedureQuery(
		name="CourseEntity.getAllCourse",
		procedureName="all_course",
		resultClasses = CourseEntity.class
)*/
@Entity
@Table(name="courses")
@DynamicUpdate //loading database trước khi update column
@EntityListeners(AuditingEntityListener.class) //Dùng để quản lý các field như ngày tháng...
public class CourseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CourseID;
	@Column(name="Title")
	private String title;
	@Column(name="Description")
	private String description;
	@Column(name="Level")
	private String level;
	@Column(name="Category")
	private String category;
	@Column(name="Language")
	private String language;
	@Column(name="Duration")
	private Integer duration;
	@Column(name="Capacity")
	private Integer capacity;
	@Column(name="price")
	private Double price;
	@Column(name="DiscountPrice")
	private Double discountPrice;
	@Column(name="Requirements")
	private String requirements;
	@Column(name="Objectives")
	private String objectives;
	@Column(name="Status")
	private String status;
	@Column(name="Syllabus")
	private String syllabus;
	@Column(name="ImageUrl")
	private String imageUrl;
	@Column(name="VideoUrl")
	private String videoUrl;
	//@CreationTimestamp
	//@Column(name="CreatedAt")
	//private LocalDateTime createdAt;
	@UpdateTimestamp
	@Column(name="UpdatedAt")
	private LocalDateTime updatedAt;
	@OneToMany(mappedBy = "courses", cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	private List<CourseModuleEntity> coursemodules = new ArrayList<>();
	public Long getCourseID() {
		return CourseID;
	}
	public void setCourseID(Long courseID) {
		CourseID = courseID;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public String getObjectives() {
		return objectives;
	}
	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}
	public String getSyllabus() {
		return syllabus;
	}
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	public List<CourseModuleEntity> getCoursemodules() {
		return coursemodules;
	}
	public void setCoursemodules(List<CourseModuleEntity> coursemodules) {
		this.coursemodules = coursemodules;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
