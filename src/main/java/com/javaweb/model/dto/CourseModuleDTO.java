package com.javaweb.model.dto;

public class CourseModuleDTO {
	private Long moduleId;
	private Long courseId;
    private String title;
    private String description;
    private String videoUrl;
    private Integer orderIndex;
    private String imageUrl;
    public Integer getOrderIndex() {
		return orderIndex;
	}
	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
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
	public Long getModuleId() {
		return moduleId;
	}
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
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
    
}

