package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javaweb.entity.Course.CourseLessonsEntity;
import com.javaweb.entity.Course.CourseModuleEntity;

public interface ICourseModuleRepository extends JpaRepository<CourseModuleEntity, Long>{
	/**
	 * Nó sẽ lấy hết các đối tượng trong các Entity sau JOIN FETCH 
	 * kia và cả từ entity sau FROM có thể dùng nhiều JOIN FETCH
	 * @Query("SELECT DISTINCT c FROM CourseEntity c " +
       "JOIN FETCH c.modules m " +
       "JOIN FETCH m.courseLessons l " +
       "WHERE c.id = :courseId")
		CourseEntity findCourseWithModulesAndLessons(@Param("courseId") Long courseId);
	 * **/
	@Query("select cm from CourseModuleEntity cm join fetch cm.courselessons")
	List<CourseLessonsEntity> getAllCourseLessons();
}
