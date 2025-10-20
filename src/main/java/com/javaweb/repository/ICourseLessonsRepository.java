package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.Course.CourseLessonsEntity;
@Repository
public interface ICourseLessonsRepository extends JpaRepository<CourseLessonsEntity, Long>{
	@Query("select cl from CourseLessonsEntity cl where cl.LessonID = :lessonId")
	CourseLessonsEntity getCourseLessonPreview(@Param("lessonId") Long lessonId);
}