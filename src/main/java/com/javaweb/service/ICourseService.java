package com.javaweb.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.dto.CourseModuleDTO;

@Service
public interface ICourseService {
	ResponseEntity<Object> createCourse(CourseDTO courseDTO);
	ResponseEntity<Object> uploadCourseImage(Long courseId, MultipartFile image);
    ResponseEntity<Object> uploadCourseVideo(Long courseId, MultipartFile video);
    ResponseEntity<Object> createModule(Long courseId, CourseModuleDTO moduleDTO);
    ResponseEntity<Object> uploadModuleVideoUrl(Long moduleId, String videoUrl);
    ResponseEntity<Object> uploadModuleImage(Long moduleId, MultipartFile image);
    ResponseEntity<Object> getAllCourse();
    ResponseEntity<Object> getCoursePreview(Long courseId);
  
}
