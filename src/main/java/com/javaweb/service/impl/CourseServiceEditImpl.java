package com.javaweb.service.impl;

import java.time.LocalDateTime;
import java.util.Map;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.builder.CourseBuilder;
import com.javaweb.builder.CourseModuleBuilder;
import com.javaweb.entity.Course.CourseEntity;
import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.dto.CourseModuleDTO;
import com.javaweb.repository.ICourseRepositoryEdit;
import com.javaweb.service.ICourseServiceEdit;

@Service
public class CourseServiceEditImpl implements ICourseServiceEdit{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ICourseRepositoryEdit courseEditRepository;
	
	//Update khóa học
	@Override
	@Transactional
	public ResponseEntity<Object> updateCourse(CourseBuilder courseBuilder) {
		CourseEntity courseEntity = courseEditRepository.findById(courseBuilder.getCourseID()).orElseThrow(() -> 
		new RuntimeException("Not found"));
		
		Long id = courseBuilder.getCourseID();
		
		if(id == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		}
		
		courseEntity.setCourseID(id);
		
		if (courseBuilder.getTitle() != null) {
            courseEntity.setTitle(courseBuilder.getTitle());
        }
        if (courseBuilder.getDescription() != null) {
            courseEntity.setDescription(courseBuilder.getDescription());
        }
        if (courseBuilder.getLevel() != null) {
            courseEntity.setLevel(courseBuilder.getLevel());
        }
        if (courseBuilder.getCategory() != null) {
            courseEntity.setCategory(courseBuilder.getCategory());
        }
        if (courseBuilder.getLanguage() != null) {
            courseEntity.setLanguage(courseBuilder.getLanguage());
        }
        if (courseBuilder.getDuration() != null) {
            courseEntity.setDuration(courseBuilder.getDuration());
        }
        if (courseBuilder.getCapacity() != null) {
            courseEntity.setCapacity(courseBuilder.getCapacity());
        }
        if (courseBuilder.getPrice() != null) {
            courseEntity.setPrice(courseBuilder.getPrice());
        }
        if (courseBuilder.getDiscountPrice() != null) {
            courseEntity.setDiscountPrice(courseBuilder.getDiscountPrice());
        }
        if (courseBuilder.getRequirements() != null) {
            courseEntity.setRequirements(courseBuilder.getRequirements());
        }
        if (courseBuilder.getObjectives() != null) {
            courseEntity.setObjectives(courseBuilder.getObjectives());
        }
        if (courseBuilder.getSyllabus() != null) {
            courseEntity.setSyllabus(courseBuilder.getSyllabus());
        }
        if (courseBuilder.getImageUrl() != null) {
            courseEntity.setImageUrl(courseBuilder.getImageUrl());
        }
        if (courseBuilder.getVideoUrl() != null) {
            courseEntity.setVideoUrl(courseBuilder.getVideoUrl());
        }
        courseEntity.setUpdatedAt(LocalDateTime.now());
        
        courseEditRepository.save(courseEntity);
        return ResponseEntity.ok(Map.of("status", "Updated Successfully!"));
	}

	@Override
	@Transactional
	public ResponseEntity<Object> deleteCourse(Long courseId) {
		//CourseEntity courseEntity = courseEditRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Not Found"));
		//courseEntity.setCourseID(courseId);
		try {
			courseEditRepository.deleteById(courseId);
			return ResponseEntity.ok(Map.of("status", "Deleted Successfully!"));
		}catch(Exception e) {
			throw new RuntimeException(e + " can not delete course");
		}
	}
}
