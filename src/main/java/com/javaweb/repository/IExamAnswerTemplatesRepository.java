package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javaweb.entity.exams.ExamAnswerTemplatesEntity;

public interface IExamAnswerTemplatesRepository extends JpaRepository<ExamAnswerTemplatesEntity, Long>{
	@Query("select eat from ExamAnswerTemplatesEntity eat join fetch eat.examTemplateQuestions"
			+ " where eat.examTemplateQuestions.QuestionID = :questionId")
	List<ExamAnswerTemplatesEntity> getExamAnswerTemplate(@Param("questionId") Long questionId);
}
