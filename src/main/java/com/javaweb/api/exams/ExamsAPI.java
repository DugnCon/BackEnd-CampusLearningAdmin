package com.javaweb.api.exams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.dto.ExamsDTO;
import com.javaweb.model.dto.TypeOfExamsDTO;
import com.javaweb.service.IExamsService;

import java.util.List;
@RestController
@RequestMapping("/api/exams")
public class ExamsAPI {
	@Autowired
	private IExamsService examsService;
    /*@GetMapping
    public List<Exam> getAllExams() {
        return null;
    }*/
	@PostMapping()
	public ResponseEntity<Object> createExams(@RequestBody ExamsDTO examsDTO) {
		return examsService.insertExams(examsDTO);
	}
	@PostMapping("/questions")
	public ResponseEntity<Object> createMultipleExams(@RequestBody TypeOfExamsDTO typeOfExamsDTO) {
		return null;
	}
}
