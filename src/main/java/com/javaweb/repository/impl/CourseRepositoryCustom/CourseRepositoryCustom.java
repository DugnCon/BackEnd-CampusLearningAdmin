package com.javaweb.repository.impl.CourseRepositoryCustom;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.entity.Course.CourseEntity;

@Repository
public interface CourseRepositoryCustom {
	List<Map<String, Object>> getAllCourse();
	Map<String,Object> getCoursePreview(Long courseId);
}
