package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.entity.Course.CourseModuleEntity;

public interface ICourseModuleRepository extends JpaRepository<CourseModuleEntity, Long>{

}
