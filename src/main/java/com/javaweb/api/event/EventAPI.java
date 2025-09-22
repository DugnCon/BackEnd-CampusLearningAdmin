package com.javaweb.api.event;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EventAPI {
	@GetMapping("/events")
	public ResponseEntity<Object> getAllEvents() {
		return null;
	}
}
