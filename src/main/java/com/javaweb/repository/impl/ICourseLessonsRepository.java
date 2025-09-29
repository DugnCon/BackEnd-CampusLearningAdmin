package com.javaweb.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.Course.CourseLessonsEntity;
@Repository
public interface ICourseLessonsRepository extends JpaRepository<CourseLessonsEntity, Long>{
	
}
