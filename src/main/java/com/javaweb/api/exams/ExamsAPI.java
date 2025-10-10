package com.javaweb.api.exams;

import com.javaweb.entity.exams.ExamAnswerTemplatesEntity;
import com.javaweb.entity.exams.ExamQuestionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javaweb.entity.exams.ExamsEntity;
import com.javaweb.model.dto.CodingExerciseDTO;
import com.javaweb.model.dto.EssayDataDTO;
import com.javaweb.model.dto.ExamsDTO;
import com.javaweb.model.dto.TypeOfExamsDTO;
import com.javaweb.service.IExamsService;

import java.util.List;
@RestController
@RequestMapping("/api")
public class ExamsAPI {
	@Autowired
	private IExamsService examsService;
	//Đưa dữ liệu ra ngoài bảng
    @GetMapping("/exams")
    public List<ExamsEntity> getAllExams() {
        return examsService.getAllExams();
    }
    
    @GetMapping("/exams/{examID}")
    public ExamsEntity getExamsPreview(@PathVariable Long examID) {

		return examsService.getExamsPreview(examID);
    }

	@GetMapping("/exams/{examId}/questions")
	public List<ExamQuestionsEntity> getQuestionsPreview(@PathVariable Long examId) {
		return examsService.getExamQuestions(examId);
	}
	
	@GetMapping("/exams/{examId}/questions/{questionId}")
	public ExamQuestionsEntity getQuestionsPreviewEdit(@PathVariable Long examId,@PathVariable Long questionId) {
		return examsService.getSingleExamQuestions(questionId);
	}
	
	@GetMapping("/exams/{examId}/questions/{questionId}/essay")
	public List<ExamAnswerTemplatesEntity> getEssayPreview(@PathVariable Long examId, @PathVariable Long questionId) {
		return examsService.getExamAnswerTemplate(questionId);
	}
	
	@PostMapping("/exams")
	public ResponseEntity<Object> createExams(@RequestBody ExamsDTO examsDTO) {
		return examsService.insertExams(examsDTO);
	}
	
	//Thêm câu hỏi trắc nghiệm hoặc các thành phần câu hỏi
	@PostMapping("/exams/{examId}/questions")
	public ResponseEntity<Object> createMultipleExams(@PathVariable Long examId, @RequestBody TypeOfExamsDTO typeOfExamsDTO) {
		return examsService.insertMultipleExams(examId, typeOfExamsDTO);
	}
	
	//Thêm câu hỏi tự luận
	@PostMapping("/exams/{examId}/questions/{questionId}/essay")
	public ResponseEntity<Object> createEssayExams(@PathVariable Long examId, @PathVariable Long questionId, @RequestBody EssayDataDTO essayDataDTO) {
		return examsService.insertEssayExams(examId, questionId, essayDataDTO);
	}
	
	//Thêm câu hỏi tự luận
	@PostMapping("/exams/{examId}/questions/{questionId}/coding")
	public ResponseEntity<Object> createCodingExams(@PathVariable Long examId, @PathVariable Long questionId, @RequestBody CodingExerciseDTO codingExerciseDTO) {
		return examsService.insertCodingExams(examId, questionId, codingExerciseDTO);
	}

	//Chỉnh sửa Exam
	@PutMapping("/exams/{examId}")
	public ResponseEntity<Object> updateExams(@PathVariable Long examId,@RequestBody ExamsDTO examsDTO) {
		return examsService.updateExams(examId, examsDTO);
	}
	
	//Update essay
	@PutMapping("/exams/{examId}/questions/{questionId}/essay/{templateId}")
	public ResponseEntity<Object> updateEssayQuestion(@PathVariable Long templateId, @RequestBody EssayDataDTO essayDataDTO) {
		return examsService.updateEssayQuestion(templateId, essayDataDTO);
	}
	
	//Xóa exam
	@DeleteMapping("/exams/{examId}")
	public ResponseEntity<Object> deleteExams(@PathVariable Long examId) {
		return examsService.deleteExams(examId);
	}
	
	//Xóa question
	@DeleteMapping("/exams/questions/{questionId}")
	public ResponseEntity<Object> deleteQuestion( @PathVariable Long questionId) {
		return examsService.deleteQuestion(questionId);
	}
}
