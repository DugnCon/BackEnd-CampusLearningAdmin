package com.javaweb.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.model.dto.EventDTO;
import com.javaweb.model.dto.EventLanguagesDTO;
import com.javaweb.model.dto.EventPrizesDTO;
import com.javaweb.model.dto.EventScheduleDTO;
import com.javaweb.model.dto.EventTechnologiesDTO;

@Service
public interface IEventService {
	ResponseEntity<Object> getAllEvent();
	ResponseEntity<Object> getEventPreview(Long eventId);
	ResponseEntity<Object> getTechnologiesPreview(Long eventId);
	ResponseEntity<Object> getLanguagesPreview(Long eventId);
	ResponseEntity<Object> getSchedulePreview(Long eventId);
	ResponseEntity<Object> getPrizesPreview(Long eventId);
	ResponseEntity<Object> getParticipantsPreview(Long eventId);
	ResponseEntity<Object> addEvent(EventDTO eventDTO);
	ResponseEntity<Object> addEventLanguages(Long eventId,EventLanguagesDTO eventLanguagesDTO);
	ResponseEntity<Object> addEventTechnologies(Long eventId,EventTechnologiesDTO eventTechnologiesDTO);
	ResponseEntity<Object> addEventSchedule(Long eventId,EventScheduleDTO eventScheduleDTO);
	ResponseEntity<Object> addEventPrizes(Long eventId,EventPrizesDTO eventPrizesDTO);
	ResponseEntity<Object> deleteEvent(Long eventId);
	ResponseEntity<Object> deleteEventSchedule(Long scheduleId);
	ResponseEntity<Object> updateEventStatus(Long eventId, EventDTO eventDTO);
	ResponseEntity<Object> updateEvent(Long eventId,EventDTO eventDTO);
}
