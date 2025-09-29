package com.javaweb.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.model.dto.ExamsDTO;
@Service
public interface IExamsService {
	ResponseEntity<Object> insertExams(ExamsDTO examsDTO);
}
