package com.javaweb.entity.Course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

//ManyToOne
@Entity
@Table(name="coursemodules")
@DynamicUpdate
public class CourseModuleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ModuleID;
	@Column(name="Title")
	private String title;
	@Column(name="CourseID", insertable = false, updatable = false)
	private Long courseId;
	@Column(name="Description", columnDefinition = "TEXT")
	private String description;
	@Column(name="VideoUrl")
	private String videoUrl;
	@Column(name="ImageUrl")
	private String imageUrl;
	@Column(name="OrderIndex")
	private Integer orderIndex;
	@Column(name="Duration")
	private Integer duration;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CourseID")
	private CourseEntity courses;
	public Integer getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Long getModuleID() {
		return ModuleID;
	}
	public void setModuleID(Long moduleID) {
		this.ModuleID = moduleID;
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
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public CourseEntity getCourses() {
		return courses;
	}
	public void setCourses(CourseEntity courses) {
		this.courses = courses;
	}
}
