package com.javaweb.repository.impl.CourseRepositoryEditCustom;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.entity.Course.CourseLessonsEntity;
@Repository
public interface CourseLessonRepositoryCustom {
	List<Map<String,Object>> getAllCourseLesson(Long moduleId);
	CourseLessonsEntity getSingleCourseLesson(Long lessonId);
}
