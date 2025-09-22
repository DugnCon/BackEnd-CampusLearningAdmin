package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.entity.Course.CourseEntity;

public interface ICourseRepositoryEdit extends JpaRepository<CourseEntity, Long>{

}
