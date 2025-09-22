package com.javaweb.builder;

import com.javaweb.entity.Course.CourseEntity;

public class CourseModuleBuilder {
    private Long moduleId;
    private Long courseId;
    private String title;
    private String description;
    private String videoUrl;
    private String imageUrl;
    private Integer orderIndex;
    private Integer duration;
    private CourseEntity courseEntity;

    private CourseModuleBuilder(Builder builder) {
        this.moduleId = builder.moduleId;
        this.courseId = builder.courseId;
        this.title = builder.title;
        this.description = builder.description;
        this.videoUrl = builder.videoUrl;
        this.imageUrl = builder.imageUrl;
        this.duration = builder.duration;
        this.orderIndex = builder.orderIndex;
        this.courseEntity = builder.courseEntity;
    }
    
    public Integer getOrderIndex() {
    	return orderIndex;
    }
    
    public Integer getDuration() {
    	return duration;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public static class Builder {
        private Long moduleId;
        private Long courseId;
        private String title;
        private String description;
        private String videoUrl;
        private String imageUrl;
        private Integer orderIndex;
        private Integer duration;
        private CourseEntity courseEntity;
        
        public Builder setDuration(Integer duration) {
        	this.duration = duration;
        	return this;
        }
        
        public Builder setOrderIndex(Integer orderIndex) {
        	this.orderIndex = orderIndex;
        	return this;
        }
        
        public Builder setModuleId(Long moduleId) {
            this.moduleId = moduleId;
            return this;
        }

        public Builder setCourseId(Long courseId) {
            this.courseId = courseId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder setCourseEntity(CourseEntity courseEntity) {
            this.courseEntity = courseEntity;
            return this;
        }

        public CourseModuleBuilder build() {
            return new CourseModuleBuilder(this);
        }
    }
}
