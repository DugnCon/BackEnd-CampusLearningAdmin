package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.Course.CourseEntity;

@Repository
public interface ICourseRepository extends JpaRepository<CourseEntity, Long>{
	//@Procedure(name = "CourseEntity.getAllCourse")
	@Query("select c from CourseEntity c")
	List<CourseEntity> getAllCourse();
}
