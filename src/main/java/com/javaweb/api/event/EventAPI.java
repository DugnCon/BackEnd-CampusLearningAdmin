package com.javaweb.api.event;

import com.javaweb.model.dto.*;
import com.javaweb.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class EventAPI {
	@Autowired
	private IEventService eventService;
	//Lấy tất cả event
	@GetMapping("/events")
	public ResponseEntity<Object> getAllEvents() {
		return eventService.getAllEvent();
	}
	
	@GetMapping("/events/{eventId}")
    public ResponseEntity<Object> getPreviewEvent(@PathVariable Long eventId) {
        try {
            return eventService.getEventPreview(eventId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("status", "error", "message", e.getMessage()));
        }
    }

    @GetMapping("/events/{eventId}/technologies")
    public ResponseEntity<Object> getPreviewTechnologies(@PathVariable Long eventId) {
        try {
            return eventService.getTechnologiesPreview(eventId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("status", "error", "message", e.getMessage()));
        }
    }

    @GetMapping("/events/{eventId}/languages")
    public ResponseEntity<Object> getPreviewLanguages(@PathVariable Long eventId) {
        try {
            return eventService.getLanguagesPreview(eventId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("status", "error", "message", e.getMessage()));
        }
    }

    @GetMapping("/events/{eventId}/schedule")
    public ResponseEntity<Object> getPreviewSchedule(@PathVariable Long eventId) {
        try {
            return eventService.getSchedulePreview(eventId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("status", "error", "message", e.getMessage()));
        }
    }

    @GetMapping("/events/{eventId}/participants")
    public ResponseEntity<Object> getPreviewParticipants(@PathVariable Long eventId) {
        try {
            return eventService.getParticipantsPreview(eventId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("status", "error", "message", e.getMessage()));
        }
    }

    @GetMapping("/events/{eventId}/prizes")
    public ResponseEntity<Object> getPreviewPrizes(@PathVariable Long eventId) {
        try {
            return eventService.getPrizesPreview(eventId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("status", "error", "message", e.getMessage()));
        }
    }
	//Edit Event
	@PutMapping("/events/{eventId}")
	public ResponseEntity<Object> updateEvent(@PathVariable Long eventId, @RequestBody EventDTO eventDTO) {
		if(eventDTO == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", HttpStatus.BAD_REQUEST.value()));
		}
		return eventService.updateEvent(eventId, eventDTO);
	}
	
	//Xóa Event
	@DeleteMapping("/events/{eventId}")
	public ResponseEntity<Object> deleteEvent(@PathVariable Long eventId) {
		return eventService.deleteEvent(eventId);
	}
	
	//Chỉnh trạng thái của event
	@PutMapping("/events/{eventId}/status")
	public ResponseEntity<Object> updateEventStatus(@PathVariable Long eventId, @RequestBody EventDTO eventDTO) {
		return eventService.updateEventStatus(eventId, eventDTO);
	}
	
	//Thêm event
	@PostMapping("/events")
	public ResponseEntity<Object> addEvent(@RequestBody EventDTO eventData) {
		return eventService.addEvent(eventData);
	}
	
	//Thêm language
	@PostMapping("/events/{eventId}/languages")
	public ResponseEntity<Object> addLanguages(@PathVariable Long eventId,@RequestBody EventLanguagesDTO eventLanguagesDTO) {
		//EventLanguagesDTO eventLanguagesDTO = new EventLanguagesDTO();
		return eventService.addEventLanguages(eventId,eventLanguagesDTO);
	}
	
	//Thêm technology
	@PostMapping("/events/{eventId}/technologies") 
	public ResponseEntity<Object> addTechnology(@PathVariable Long eventId,@RequestBody EventTechnologiesDTO eventTechnologiesDTO) {
		//EventTechnologiesDTO eventTechnologiesDTO = new EventTechnologiesDTO();
		//eventTechnologiesDTO.setTechnology(technology);
		return eventService.addEventTechnologies(eventId,eventTechnologiesDTO);
	}
	
	//Thêm schedule
	@PostMapping("/events/{eventId}/schedule")
	public ResponseEntity<Object> addSchedule(@PathVariable Long eventId,@RequestBody EventScheduleDTO scheduleData) {
		return eventService.addEventSchedule(eventId,scheduleData);
	}
	
	@DeleteMapping("/events/{eventId}/schedule/{scheduleId}")
	public ResponseEntity<Object> deleteSchedule(@PathVariable Long eventId,@PathVariable Long scheduleId) {
		return eventService.deleteEventSchedule(scheduleId);
	}
	
	//Thêm phần thưởng
	@PostMapping("/events/{eventId}/prizes")
	public ResponseEntity<Object> addPrize(@PathVariable Long eventId,@RequestBody EventPrizesDTO prizeData) {
		return eventService.addEventPrizes(eventId,prizeData);
	}
	
	
}
