package com.javaweb.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.javaweb.entity.exams.ExamAnswerTemplatesEntity;
import com.javaweb.entity.exams.ExamQuestionsEntity;
import com.javaweb.model.dto.TypeOfExamsDTO;
import com.javaweb.repository.IExamQuestionsRepository;
import com.javaweb.utils.NullAwareBeanUtils;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.entity.Course.CourseEntity;
import com.javaweb.entity.coding.CodingExercisesEntity;
import com.javaweb.entity.exams.ExamsEntity;
import com.javaweb.model.dto.CodingExerciseDTO;
import com.javaweb.model.dto.EssayDataDTO;
import com.javaweb.model.dto.ExamsDTO;
import com.javaweb.repository.ICodingExercisesRepository;
import com.javaweb.repository.ICourseRepository;
import com.javaweb.repository.IExamAnswerTemplatesRepository;
import com.javaweb.repository.IExamsRepository;
import com.javaweb.service.IExamsService;
import com.javaweb.utils.MapUtils;
@Service
public class ExamsServiceImpl implements IExamsService{
	@Autowired
	private IExamQuestionsRepository examQuestionsRepository;
	//Thêm bài kiểm tra 
	@Autowired
	private ICourseRepository courseRepository;
	@Autowired
	private IExamsRepository examsRepository;
	@Autowired
	private IExamAnswerTemplatesRepository examAnswerTemplateRepository;
	@Autowired
	private ICodingExercisesRepository codingExercisesRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	@Transactional
	public ResponseEntity<Object> insertExams(ExamsDTO examsDTO) {
		Long courseId = examsDTO.getCourseId();
		CourseEntity courseEntity = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Not found!"));
		try {
			ExamsEntity examsEntity = modelMapper.map(examsDTO, ExamsEntity.class);
			examsEntity.setCourseExams(courseEntity);
			examsRepository.save(examsEntity);
			return ResponseEntity.ok(Map.of("examId", examsEntity.getExamID()));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", e.getStackTrace()));
		}
	}
	@Override
	@Transactional
	public ResponseEntity<Object> insertMultipleExams(Long examId,TypeOfExamsDTO typeOfExamsDTO) {
		ExamsEntity examsEntity = examsRepository.findById(examId).orElseThrow(() -> new RuntimeException("Not found"));
		try {
			ExamQuestionsEntity examQuestionsEntity = modelMapper.map(typeOfExamsDTO, ExamQuestionsEntity.class);
			
			if(typeOfExamsDTO.getOptions() != null) {
				String options = typeOfExamsDTO.getOptions().stream().collect(Collectors.joining(";"));
				examQuestionsEntity.setOption(options);
			}
			
			examQuestionsEntity.setExams(examsEntity);
			examQuestionsEntity.setType(examsEntity.getType());
			
			examQuestionsRepository.save(examQuestionsEntity);
			
			return ResponseEntity.ok(Map.of("questionId", examQuestionsEntity.getQuestionID()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", e.getStackTrace()));
		}
	}
	@Override
	@Transactional
	public ResponseEntity<Object> insertEssayExams(Long examId, Long questionId, EssayDataDTO essayDataDTO) {
		ExamQuestionsEntity examQuestionsEntity = examQuestionsRepository.findById(questionId).orElseThrow(() -> new RuntimeException("not found questions"));
		try {
			String keywords = essayDataDTO.getKeywords().stream().collect(Collectors.joining(";"));
			ExamAnswerTemplatesEntity examAnswerTemplateEntity = new ExamAnswerTemplatesEntity();
			
			examAnswerTemplateEntity.setContent(essayDataDTO.getContent());
			//examAnswerTemplateEntity.setMinimumMatchPercentage(typeOfExamsDTO.getMinimumMatchPercentage());
			examAnswerTemplateEntity.setKeywords(keywords);
			examAnswerTemplateEntity.setMinimumMatchPercentage(essayDataDTO.getMinimumMatchPercentage());
			examAnswerTemplateEntity.setExamTemplateQuestions(examQuestionsEntity);
			examAnswerTemplateEntity.setExamTemplates(examQuestionsEntity.getExams());
			
			examAnswerTemplateRepository.save(examAnswerTemplateEntity);
			return ResponseEntity.ok(HttpStatus.OK.value());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", e.getStackTrace()));
		}
	}
	@Override
	public List<ExamsEntity> getAllExams() {

		return examsRepository.getAllExams();
	}
	@Override
	public ExamsEntity getExamsPreview(Long examId) {
		return examsRepository.getExamsPreview(examId);
	}
	@Override
	@Transactional
	public ResponseEntity<Object> updateExams(Long examId, ExamsDTO examsDTO) {
		ExamsEntity examsEntity = examsRepository.findById(examId).orElseThrow(() -> new RuntimeException("Not found"));
		try {
			NullAwareBeanUtils.copyNonNullProperties(examsDTO, examsEntity);
			examsRepository.save(examsEntity);
			return ResponseEntity.ok(HttpStatus.OK.value());
		} catch (Exception e) {
			throw new RuntimeException(e + "Can not update exams");
        }
	}
	@Override
	public ResponseEntity<Object> deleteExams(Long examId) {
		//ExamsEntity examsEntity = examsRepository.findById(examId).orElseThrow(() -> new RuntimeException("Not found"));
		try {
			examsRepository.deleteById(examId);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e + "Can not delete exams");
		}
	}
	@Override
	public List<ExamQuestionsEntity> getExamQuestions(Long examId) {
		try {
			List<ExamQuestionsEntity> entity = examQuestionsRepository.getExamQuestions(examId);
			return entity;
		} catch (Exception e) {
			throw new RuntimeException(e + "Can not get exam question");
		}
	}
	@Override
	public List<ExamAnswerTemplatesEntity> getExamAnswerTemplate(Long questionId) {
		try {
			return examAnswerTemplateRepository.getExamAnswerTemplate(questionId);
		} catch (Exception e) {
			throw new RuntimeException(e + "Can not get exam answer template");
		}
	}
	@Override
	@Transactional
	public ResponseEntity<Object> insertCodingExams(Long examId, Long questionId, CodingExerciseDTO codingExerciseDTO) {
		try {
			CodingExercisesEntity codingExercise = modelMapper.map(codingExerciseDTO, CodingExercisesEntity.class);
			codingExercisesRepository.save(codingExercise);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch(Exception e) {
			throw new RuntimeException(e + " Can not insert coding exercise");
		}
	}
	//Lấy 1 entity question
	@Override
	public ExamQuestionsEntity getSingleExamQuestions(Long questionId) {
		try {
			return examQuestionsRepository.getSingleExamQuestions(questionId);
		} catch(Exception e) {
			throw new RuntimeException(e + "Can not get single question");
		}
	}
	@Override
	public ResponseEntity<Object> deleteQuestion(Long questionId) {
		//ExamQuestionsEntity examQuestionsEntity = examQuestionsRepository.findById(questionId).orElseThrow(() -> new RuntimeException("not found question"));
		try {
			examQuestionsRepository.deleteById(questionId);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch(Exception e) {
			throw new RuntimeException(e + "Can not delete question");
		}
	}
	@Override
	public ResponseEntity<Object> updateEssayQuestion(Long templateId, EssayDataDTO essayDataDTO) {
		ExamAnswerTemplatesEntity entity = examAnswerTemplateRepository.findById(templateId).orElseThrow(() -> new RuntimeException("Not found"));
		try {
			String keywords = essayDataDTO.getKeywords().stream().collect(Collectors.joining(","));
			NullAwareBeanUtils.copyNonNullProperties(essayDataDTO, entity);
			entity.setKeywords(keywords);
			examAnswerTemplateRepository.save(entity);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e + "Can not update essay question");
		}
	}
}
