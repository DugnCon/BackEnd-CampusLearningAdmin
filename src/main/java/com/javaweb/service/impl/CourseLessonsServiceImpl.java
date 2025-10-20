package com.javaweb.service.impl;

import java.util.Map;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.entity.Course.CourseLessonsEntity;
import com.javaweb.entity.Course.CourseModuleEntity;
import com.javaweb.model.dto.CourseLessonsDTO;
import com.javaweb.repository.ICourseModuleRepository;
import com.javaweb.repository.ICourseLessonsRepository;
import com.javaweb.repository.impl.CourseRepositoryEditCustom.CourseLessonRepositoryCustom;
import com.javaweb.service.ICourseLessonService;
import com.javaweb.utils.MapUtils;
@Service
public class CourseLessonsServiceImpl implements ICourseLessonService{
	@Autowired
	private ICourseModuleRepository courseModuleRepository;
	@Autowired
	private ICourseLessonsRepository courseLessonsRepository;
	@Autowired
	private CourseLessonRepositoryCustom courseLessonCustom;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	@Transactional
	public ResponseEntity<Object> insertCourseLesson(Long moduleId,CourseLessonsDTO courseLessonsDTO) {
		CourseModuleEntity courseModuleEntity = courseModuleRepository.findById(moduleId)
				.orElseThrow(() -> new RuntimeException("Not found"));
		CourseLessonsEntity courseLessonsEntity = modelMapper.map(courseLessonsDTO, CourseLessonsEntity.class);
		courseLessonsEntity.setModules(courseModuleEntity);
		courseLessonsRepository.save(courseLessonsEntity);
		return ResponseEntity.ok(Map.of("status", "Successfully added lesson!", "LessonID", courseLessonsEntity.getLessonID()));
	}
	@Override
	public ResponseEntity<Object> getAllCourseLesson(Long moduleId) {
		return ResponseEntity.ok(Map.of("lessons", courseLessonCustom.getAllCourseLesson(moduleId)));
	}
	@Override
	public CourseLessonsEntity getSingleCourseLesson(Long lessonId) {
		return courseLessonsRepository.getCourseLessonPreview(lessonId);
	}
	@Override
	public ResponseEntity<Object> deleteCourseLesson(Long lessonId) {
		if(lessonId != null) {
			courseLessonsRepository.deleteById(lessonId);
			return ResponseEntity.ok(Map.of("status", "Successfully deleted lesson!")); 
		}
		return ResponseEntity.ok(Map.of("error", "LessonID is null"));
	}
	@Override
	public ResponseEntity<Object> updateCourseLesson(Long lessonId,CourseLessonsDTO courseLessonsDTO) {
		CourseLessonsEntity courseLessonsEntity = courseLessonsRepository.findById(lessonId).orElseThrow(() -> new RuntimeException("not found lesson"));
		if(MapUtils.getObjectTwo(courseLessonsDTO.getTitle(), String.class)) {
			courseLessonsEntity.setTitle(courseLessonsDTO.getTitle());
		}
		if(MapUtils.getObjectTwo(courseLessonsDTO.getDescription(), String.class)) {
			courseLessonsEntity.setDescription(courseLessonsDTO.getDescription());
		}
		if(MapUtils.getObjectTwo(courseLessonsDTO.getType(), String.class)) {
			courseLessonsEntity.setType(courseLessonsDTO.getType());;
		}
		if(MapUtils.getObjectTwo(courseLessonsDTO.getDuration(), Integer.class)) {
			courseLessonsEntity.setDuration(courseLessonsDTO.getDuration());
		}
		if(MapUtils.getObjectTwo(courseLessonsDTO.getVideoUrl(), String.class)) {
			courseLessonsEntity.setVideoUrl(courseLessonsDTO.getVideoUrl());
		}
		if(MapUtils.getObjectTwo(courseLessonsDTO.getOrderIndex(), Integer.class)) {
			courseLessonsEntity.setOrderIndex(courseLessonsDTO.getOrderIndex());
		}
		courseLessonsEntity.setPreview(courseLessonsDTO.isPreview());
		if(MapUtils.getObjectTwo(courseLessonsDTO.getContent(), String.class)) {
			courseLessonsEntity.setContent(courseLessonsDTO.getContent());
		}
		courseLessonsRepository.save(courseLessonsEntity);
		return ResponseEntity.ok(Map.of("status", "Successfully updated lesson"));
	}

}
