package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.entity.coding.CodingExercisesEntity;

public interface ICodingExercisesRepository extends JpaRepository<CodingExercisesEntity, Long>{}
