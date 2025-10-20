package com.javaweb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.builder.CourseModuleBuilder;
import com.javaweb.entity.Course.CourseEntity;
import com.javaweb.entity.Course.CourseModuleEntity;
import com.javaweb.repository.ICourseModuleRepository;
import com.javaweb.repository.ICourseRepository;
import com.javaweb.repository.impl.CourseRepositoryCustom.CourseRepositoryCustom;
import com.javaweb.service.ICourseModuleServiceEdit;

@Service
public class CourseModuleServiceEdit implements ICourseModuleServiceEdit{
	
	@Autowired
	private ICourseModuleRepository courseModuleRepository;
	@Autowired
	private CourseRepositoryCustom courseModuleRepositoryCustom;
	@Autowired
	private ICourseRepository courseRepository;

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
	public ResponseEntity<Object> deleteCoureModule(Long courseId,Long moduleId) {
		if(moduleId != null) {
			courseModuleRepository.deleteById(moduleId);
			return ResponseEntity.ok(Map.of("status", "Successfully deleted module"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "ModuleID is null"));
	}

	@Override
	public ResponseEntity<Object> getCoureModule(Long courseId) {
		//List<CourseModuleEntity> courseModuleEntity = courseModuleRepository.findByCourseID(courseId);
		//return ResponseEntity.ok(courseModuleEntity);
		return ResponseEntity.ok(Map.of("modules", courseModuleRepositoryCustom.getCourseModule(courseId)));
	}

	@Override
	public ResponseEntity<Object> getCoureModulePreview(Long moduleId) {
		return ResponseEntity.ok(courseModuleRepositoryCustom.getCourseModulePreview(moduleId).get(0));
	}

}
