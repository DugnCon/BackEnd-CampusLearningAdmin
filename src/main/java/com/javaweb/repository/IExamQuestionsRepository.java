package com.javaweb.repository;

import com.javaweb.entity.exams.ExamQuestionsEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IExamQuestionsRepository extends JpaRepository<ExamQuestionsEntity, Long> { 
	@Query("select exq from ExamQuestionsEntity exq join fetch exq.exams where exq.exams.ExamID = :examId")
	List<ExamQuestionsEntity> getExamQuestions(@Param("examId") Long examId);
	@Query("select exq from ExamQuestionsEntity exq join fetch exq.exams where exq.QuestionID = :questionId")
	ExamQuestionsEntity getSingleExamQuestions(@Param("questionId") Long questionId);
}
