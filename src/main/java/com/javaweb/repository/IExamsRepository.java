package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.exams.ExamsEntity;
@Repository
public interface IExamsRepository extends JpaRepository<ExamsEntity, Long>{
	@Query("select ex from ExamsEntity ex")
	List<ExamsEntity> getAllExams();
	@Query("select ex from ExamsEntity ex join fetch ex.courseExams where ExamID = :examId")
	ExamsEntity getExamsPreview(@Param("examId") Long examId);
}
