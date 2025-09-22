package com.javaweb.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.builder.CourseModuleBuilder;
import com.javaweb.entity.Course.CourseModuleEntity;
import com.javaweb.repository.ICourseModuleRepository;
import com.javaweb.service.ICourseModuleServiceEdit;

@Service
public class CourseModuleServiceEdit implements ICourseModuleServiceEdit{
	
	@Autowired
	private ICourseModuleRepository courseModuleRepository;

	@Override
	public ResponseEntity<Object> updateCoureModule(CourseModuleBuilder courseModuleBuilder, Long courseId,Long moduleId) {
		CourseModuleEntity courseModuleEntity = courseModuleRepository.findById(moduleId).orElseThrow(() -> new RuntimeException("Not found"));
		Long id = courseModuleEntity.getModuleID();
		if(id == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		}
		if(courseModuleBuilder.getTitle() != null && !courseModuleBuilder.getTitle().isEmpty()) {
			courseModuleEntity.setTitle(courseModuleBuilder.getTitle());
		}
		if(courseModuleBuilder.getDescription() != null && !courseModuleBuilder.getDescription().isEmpty()) {
			courseModuleEntity.setDescription(courseModuleBuilder.getDescription());
		}
		if(courseModuleBuilder.getImageUrl() != null && !courseModuleBuilder.getImageUrl().isEmpty()) {
			courseModuleEntity.setImageUrl(courseModuleBuilder.getImageUrl());
		}
		if(courseModuleBuilder.getVideoUrl() != null && !courseModuleBuilder.getVideoUrl().isEmpty()) {
			courseModuleEntity.setVideoUrl(courseModuleBuilder.getVideoUrl());
		}
		if(courseModuleBuilder.getOrderIndex() != null) {
			courseModuleEntity.setOrderIndex(courseModuleBuilder.getOrderIndex());
		}
		if(courseModuleBuilder.getDuration() != null) {
			courseModuleEntity.setDuration(courseModuleBuilder.getDuration());
		}
		courseModuleRepository.save(courseModuleEntity);
		return ResponseEntity.ok(Map.of("status", "Saved module Successfully!"));
	}

	@Override
	public ResponseEntity<Object> deleteCoureModule(CourseModuleBuilder courseModuleBuilder, Long courseId,
			Long moduleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
