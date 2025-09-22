package com.javaweb.builder;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.model.dto.CourseModuleDTO;

public class CourseBuilder {
	private Long courseID;
    private String title;
    private String description;
    private String level;        
    private String category;
    private String language;    
    private Integer duration;    
    private Integer capacity;  
    private Double price;       
    private Double discountPrice; 
    private String requirements; 
    private String objectives;   
    private String syllabus;    
    private String imageUrl;     
    private String videoUrl;   
    private Boolean isPublished; 
    private String slug;       
    private List<CourseModuleDTO> coursemodules = new ArrayList<>();
    
    private CourseBuilder(Builder builder) {
    	this.courseID = builder.courseID;
    	this.title = builder.title;
    	this.description = builder.description;
    	this.level = builder.level;
    	this.category = builder.category;
    	this.language = builder.language;
    	this.duration = builder.duration;
    	this.capacity = builder.capacity;
    	this.price = builder.price;
    	this.discountPrice = builder.price;
    	this.requirements = builder.requirements;
    	this.objectives = builder.objectives;
    	this.syllabus = builder.syllabus;
    	this.imageUrl = builder.imageUrl;
    	this.videoUrl = builder.videoUrl;
    	this.isPublished = builder.isPublished;
    	this.slug = builder.slug;
    	this.coursemodules = builder.coursemodules;
    }
    
    
    
    public Long getCourseID() {
		return courseID;
	}

	public void setCourseID(Long courseID) {
		this.courseID = courseID;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
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

	public Boolean getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public List<CourseModuleDTO> getCoursemodules() {
		return coursemodules;
	}

	public void setCoursemodules(List<CourseModuleDTO> coursemodules) {
		this.coursemodules = coursemodules;
	}

	public static class Builder {
	    private Long courseID;
	    private String title;
	    private String description;
	    private String level;        
	    private String category;
	    private String language;    
	    private Integer duration;    
	    private Integer capacity;  
	    private Double price;       
	    private Double discountPrice; 
	    private String requirements; 
	    private String objectives;   
	    private String syllabus;    
	    private String imageUrl;     
	    private String videoUrl;   
	    private Boolean isPublished; 
	    private String slug;       
	    private List<CourseModuleDTO> coursemodules = new ArrayList<>();

	    public Builder setCourseID(Long courseID) {
	        this.courseID = courseID;
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
	    public Builder setLevel(String level) {
	        this.level = level;
	        return this;
	    }
	    public Builder setCategory(String category) {
	        this.category = category;
	        return this;
	    }
	    public Builder setLanguage(String language) {
	        this.language = language;
	        return this;
	    }
	    public Builder setDuration(Integer duration) {
	        this.duration = duration;
	        return this;
	    }
	    public Builder setCapacity(Integer capacity) {
	        this.capacity = capacity;
	        return this;
	    }
	    public Builder setPrice(Double price) {
	        this.price = price;
	        return this;
	    }
	    public Builder setDiscountPrice(Double discountPrice) {
	        this.discountPrice = discountPrice;
	        return this;
	    }
	    public Builder setRequirements(String requirements) {
	        this.requirements = requirements;
	        return this;
	    }
	    public Builder setObjectives(String objectives) {
	        this.objectives = objectives;
	        return this;
	    }
	    public Builder setSyllabus(String syllabus) {
	        this.syllabus = syllabus;
	        return this;
	    }
	    public Builder setImageUrl(String imageUrl) {
	        this.imageUrl = imageUrl;
	        return this;
	    }
	    public Builder setVideoUrl(String videoUrl) {
	        this.videoUrl = videoUrl;
	        return this;
	    }
	    public Builder setIsPublished(Boolean isPublished) {
	        this.isPublished = isPublished;
	        return this;
	    }
	    public Builder setSlug(String slug) {
	        this.slug = slug;
	        return this;
	    }
	    public Builder setCoursemodules(List<CourseModuleDTO> coursemodules) {
	        this.coursemodules = coursemodules;
	        return this;
	    }

	    public CourseBuilder build() {
	        return new CourseBuilder(this);
	    }
	}
}
