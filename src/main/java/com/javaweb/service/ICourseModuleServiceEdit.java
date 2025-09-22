package com.javaweb.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.builder.CourseModuleBuilder;

@Service
public interface ICourseModuleServiceEdit {
	ResponseEntity<Object> updateCoureModule(CourseModuleBuilder courseModuleBuilder, Long courseId, Long moduleId);
	ResponseEntity<Object> deleteCoureModule(CourseModuleBuilder courseModuleBuilder, Long courseId, Long moduleId);
}
