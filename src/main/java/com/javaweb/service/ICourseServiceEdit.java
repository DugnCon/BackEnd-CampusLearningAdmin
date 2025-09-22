package com.javaweb.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.builder.CourseBuilder;
import com.javaweb.builder.CourseModuleBuilder;
import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.dto.CourseModuleDTO;

@Service
public interface ICourseServiceEdit {
	ResponseEntity<Object> updateCourse(CourseBuilder courseBuilder);
	ResponseEntity<Object> deleteCourse(Long courseId);
}
