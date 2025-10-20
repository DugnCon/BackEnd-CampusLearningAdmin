package com.javaweb.service;

import com.javaweb.model.dto.TypeOfExamsDTO;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.entity.exams.ExamAnswerTemplatesEntity;
import com.javaweb.entity.exams.ExamQuestionsEntity;
import com.javaweb.entity.exams.ExamsEntity;
import com.javaweb.model.dto.CodingExerciseDTO;
import com.javaweb.model.dto.EssayDataDTO;
import com.javaweb.model.dto.ExamsDTO;
@Service
public interface IExamsService {
	List<ExamsEntity> getAllExams(); 
	ExamsEntity getExamsPreview(Long examId);
	List<ExamQuestionsEntity> getExamQuestions(Long examId);
	ExamQuestionsEntity getSingleExamQuestions(Long questionId);
	List<ExamAnswerTemplatesEntity> getExamAnswerTemplate(Long questionId);
	
	ResponseEntity<Object> insertExams(ExamsDTO examsDTO);
	ResponseEntity<Object> insertMultipleExams(Long examId,TypeOfExamsDTO typeOfExamsDTO);
	ResponseEntity<Object> insertEssayExams(Long examId, Long questionId, EssayDataDTO essayDataDTO);
	ResponseEntity<Object> insertCodingExams(Long examId, Long questionId, CodingExerciseDTO codingExerciseDTO);
	
	ResponseEntity<Object> updateExams(Long examId, ExamsDTO examsDTO);
	ResponseEntity<Object> updateEssayQuestion(Long templateId, EssayDataDTO essayDataDTO);
	ResponseEntity<Object> deleteExams(Long examId);
	ResponseEntity<Object> deleteQuestion(Long questionId);
}
