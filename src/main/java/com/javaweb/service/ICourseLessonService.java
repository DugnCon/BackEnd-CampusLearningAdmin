package com.javaweb.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.entity.Course.CourseLessonsEntity;
import com.javaweb.model.dto.CourseLessonsDTO;
@Service
public interface ICourseLessonService {
	ResponseEntity<Object> insertCourseLesson(Long moduleId, CourseLessonsDTO courseLessonsDTO);
	ResponseEntity<Object> getAllCourseLesson(Long moduleId);
	CourseLessonsEntity getSingleCourseLesson(Long lessonId);
	ResponseEntity<Object> deleteCourseLesson(Long lessonId);
	ResponseEntity<Object> updateCourseLesson(Long lessonId,CourseLessonsDTO courseLesonsDTO);
	
}
