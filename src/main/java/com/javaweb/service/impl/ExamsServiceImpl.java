package com.javaweb.service.impl;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.entity.Course.CourseEntity;
import com.javaweb.entity.exams.ExamsEntity;
import com.javaweb.model.dto.ExamsDTO;
import com.javaweb.repository.ICourseRepository;
import com.javaweb.repository.IExamsRepository;
import com.javaweb.service.IExamsService;
@Service
public class ExamsServiceImpl implements IExamsService{
	//Thêm bài kiểm tra 
	@Autowired
	private ICourseRepository courseRepository;
	@Autowired
	private IExamsRepository examsRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public ResponseEntity<Object> insertExams(ExamsDTO examsDTO) {
		Long courseId = examsDTO.getCourseID();
		CourseEntity courseEntity = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Not found!"));
		ExamsEntity examsEntity = modelMapper.map(examsDTO, ExamsEntity.class);
		examsEntity.setCourseExams(courseEntity);
		examsRepository.save(examsEntity);
		return ResponseEntity.ok(Map.of("examId", examsEntity.getExamID()));
	}

}
