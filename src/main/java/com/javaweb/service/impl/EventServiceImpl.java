package com.javaweb.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.entity.event.EventEntity;
import com.javaweb.entity.event.EventPrizesEntity;
import com.javaweb.entity.event.EventProgrammingLanguagesEntity;
import com.javaweb.entity.event.EventScheduleEntity;
import com.javaweb.entity.event.EventTechnologiesEntity;
import com.javaweb.model.dto.EventDTO;
import com.javaweb.model.dto.EventLanguagesDTO;
import com.javaweb.model.dto.EventPrizesDTO;
import com.javaweb.model.dto.EventScheduleDTO;
import com.javaweb.model.dto.EventTechnologiesDTO;
import com.javaweb.repository.IEventParticipantsRepository;
import com.javaweb.repository.IEventPrizesRepository;
import com.javaweb.repository.IEventProgrammingLanguagesRepository;
import com.javaweb.repository.IEventRepository;
import com.javaweb.repository.IEventScheduleRepository;
import com.javaweb.repository.IEventTechnologiesRepository;
import com.javaweb.repository.impl.EventRepositoryCustom.EventRepositoryCustom;
import com.javaweb.service.IEventService;
import com.javaweb.utils.MapUtils;

@Service
public class EventServiceImpl implements IEventService{
	@Autowired
	private IEventRepository eventRepository;
	@Autowired
	private IEventProgrammingLanguagesRepository eventLanguagesRepository;
	@Autowired
	private IEventScheduleRepository eventScheduleRepository;
	@Autowired
	private IEventPrizesRepository eventPrizesRepository;
	@Autowired
	private IEventTechnologiesRepository eventTechnologiesRepository;
	@Autowired
	private IEventParticipantsRepository eventParticipantsRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private EventRepositoryCustom eventRepositoryCustom;
	//Tìm tất cả các event
	@Override
	@Transactional
	public ResponseEntity<Object> getAllEvent() {
		List<Map<String,Object>> eventEntity = eventRepositoryCustom.getAllEvent();
		return ResponseEntity.ok(eventEntity);
	}

	@Override
	@Transactional
	public ResponseEntity<Object> getEventPreview(Long eventId) {
	    return ResponseEntity.ok(eventRepositoryCustom.getEventPreview(eventId));
	}


	//Thêm khóa học
	@Override
	@Transactional
	public ResponseEntity<Object> addEvent(EventDTO eventDTO) {
		EventEntity eventEntity = modelMapper.map(eventDTO, EventEntity.class);
		eventRepository.save(eventEntity);
		return ResponseEntity.ok(Map.of("status", "Successfully added event!", "eventId", eventEntity.getEventID()));
	}

	@Override
	public ResponseEntity<Object> addEventLanguages(Long eventId,EventLanguagesDTO eventLanguagesDTO) {
		EventEntity eventEntity = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("not found"));
		if(eventEntity == null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body(Map.of("status", "error", "message", "Event not found")); 
		}
		//String languages = eventLanguagesDTO.getLanguage();
		//eventLanguagesDTO.setEventID(eventId);
		EventProgrammingLanguagesEntity eventLanguagesEntity = modelMapper.map(eventLanguagesDTO, EventProgrammingLanguagesEntity.class);
		eventLanguagesEntity.setEvents(eventEntity);
		eventLanguagesRepository.save(eventLanguagesEntity);
		return ResponseEntity.ok(Map.of("status","Saved OK!"));
	}

	@Override
	public ResponseEntity<Object> addEventTechnologies(Long eventId,EventTechnologiesDTO eventTechnologiesDTO) {
		EventEntity eventEntity = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("not found"));
		if(eventEntity == null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body(Map.of("status", "error", "message", "Event not found")); 
		}
		//String technologies = eventTechnologiesDTO.getTechnology();
		EventTechnologiesEntity eventTechnologiesEntity = modelMapper.map(eventTechnologiesDTO, EventTechnologiesEntity.class);
		eventTechnologiesEntity.setEventTechnology(eventEntity);
		eventTechnologiesRepository.save(eventTechnologiesEntity);
		return ResponseEntity.ok(Map.of("status","Saved OK!"));
	}

	@Override
	public ResponseEntity<Object> addEventSchedule(Long eventId,EventScheduleDTO eventScheduleDTO) {
		EventEntity eventEntity = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("not found"));
		if(eventEntity == null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body(Map.of("status", "error", "message", "Event not found")); 
		}
		EventScheduleEntity eventScheduleEntity = modelMapper.map(eventScheduleDTO, EventScheduleEntity.class);
		eventScheduleEntity.setEventSchedule(eventEntity);
		eventScheduleRepository.save(eventScheduleEntity);
		return ResponseEntity.ok(Map.of("status","Saved OK!"));
	}

	@Override
	public ResponseEntity<Object> addEventPrizes(Long eventId,EventPrizesDTO eventPrizesDTO) {
		EventEntity eventEntity = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("not found"));
		if(eventEntity == null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body(Map.of("status", "error", "message", "Event not found")); 
		}
		EventPrizesEntity eventPrizesEntity = modelMapper.map(eventPrizesDTO, EventPrizesEntity.class);
		eventPrizesEntity.setEventPrize(eventEntity);
		eventPrizesRepository.save(eventPrizesEntity);
		return ResponseEntity.ok(Map.of("status","Saved OK!"));
	}

	@Override
	@Transactional
	public ResponseEntity<Object> updateEvent(Long eventId,EventDTO eventDTO) {
		EventEntity eventEntity = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Not found"));
		//Nếu không tìm thấy lỗi thì tiếp tục
		if(eventDTO.getTitle() != null && !eventDTO.getTitle().isEmpty()) {
			eventEntity.setTitle(eventDTO.getTitle());
		}
		if(eventDTO.getDescription() != null && !eventDTO.getDescription().isEmpty()) {
			eventEntity.setDescription(eventDTO.getDescription());
		}
		if(eventDTO.getCategory() != null && !eventDTO.getCategory().isEmpty()) {
			eventEntity.setCategory(eventDTO.getCategory());
		}
		if(eventDTO.getDifficulty() != null && !eventDTO.getDifficulty().isEmpty()) {
			eventEntity.setDifficulty(eventDTO.getDifficulty());
		}
		if(eventDTO.getEventDate() != null) {
			eventEntity.setEventDate(eventDTO.getEventDate());
		}
		if(eventDTO.getEventTime() != null) {
			eventEntity.setEventTime(eventDTO.getEventTime());
		}
		if(eventDTO.getStatus() != null && !eventDTO.getStatus().isEmpty()) {
			eventEntity.setStatus(eventDTO.getStatus());
		}
		if(eventDTO.getLocation() != null && !eventDTO.getLocation().isEmpty()) {
			eventEntity.setLocation(eventDTO.getLocation());
		}
		if(MapUtils.getObjectTwo(eventDTO.getImageUrl(), String.class)) {
			eventEntity.setImageUrl(eventDTO.getImageUrl());
		}
		if(MapUtils.getObjectTwo(eventDTO.getOrganizer(), String.class)) {
			eventEntity.setOrganizer(eventDTO.getOrganizer());
		}
		if(MapUtils.getObjectTwo(eventDTO.getMaxAttendees(), Integer.class)) {
			eventEntity.setMaxAttendees(eventDTO.getMaxAttendees());
		}
		if(MapUtils.getObjectTwo(eventDTO.getPrice(), Double.class)) {
			eventEntity.setPrice(eventDTO.getPrice());
		}
		eventEntity.setEventID(eventId);
		eventRepository.save(eventEntity);
		return ResponseEntity.ok(Map.of("status","Successfully Updated Event!"));
	}

	@Override
	public ResponseEntity<Object> deleteEvent(Long eventId) {
		EventEntity eventEntity = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Not found"));
		eventEntity.setEventID(eventId);
		eventRepository.delete(eventEntity);
		return ResponseEntity.ok(Map.of("status", "Successfully deleted event!"));
	}

	@Override
	public ResponseEntity<Object> updateEventStatus(Long eventId, EventDTO eventDTO) {
		String status = eventDTO.getStatus();
		if(status != null && !status.isEmpty()) {
			int rows = eventRepository.updateEventStatus(eventId, status);
			if(rows > 0) {
				return ResponseEntity.ok(Map.of("status", "Successfully updated event status"));
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Not Successfully updated event status"));
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", HttpStatus.BAD_REQUEST.value()));
	}

	@Override
	public ResponseEntity<Object> getTechnologiesPreview(Long eventId) {
		return ResponseEntity.ok(eventTechnologiesRepository.findByEventId(eventId));
	}

	@Override
	public ResponseEntity<Object> getLanguagesPreview(Long eventId) {
		
		return ResponseEntity.ok(eventLanguagesRepository.findByEventId(eventId));
	}
	
	@Override
	public ResponseEntity<Object> getSchedulePreview(Long eventId) {
		return ResponseEntity.ok(eventScheduleRepository.findByEventId(eventId));
	}

	@Override
	public ResponseEntity<Object> getPrizesPreview(Long eventId) {
		return ResponseEntity.ok(eventPrizesRepository.findByEventId(eventId));
	}

	@Override
	public ResponseEntity<Object> getParticipantsPreview(Long eventId) {
		return ResponseEntity.ok(eventParticipantsRepository.findByEventId(eventId));
	}

	@Override
	public ResponseEntity<Object> deleteEventSchedule(Long scheduleId) {
		eventScheduleRepository.deleteById(scheduleId);
		return ResponseEntity.ok(Map.of("status", "Successfully deleted schedule"));
	}

}
