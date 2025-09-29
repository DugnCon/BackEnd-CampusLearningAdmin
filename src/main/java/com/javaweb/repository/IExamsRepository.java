package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.exams.ExamsEntity;
@Repository
public interface IExamsRepository extends JpaRepository<ExamsEntity, Long>{}
