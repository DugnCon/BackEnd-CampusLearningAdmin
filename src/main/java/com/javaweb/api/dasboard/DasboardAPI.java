package com.javaweb.api.dasboard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DasboardAPI {
	@GetMapping("/stats")
    public ResponseEntity<Object> getStats() {
        // return stats data
		return null;
    }

    @GetMapping("/activities")
    public ResponseEntity<Object> getActivities() {
        // return activities list
    	return null;
    }

    @GetMapping("/notifications")
    public ResponseEntity<Object> getNotifications() {
        // return notifications list
    	return null;
    }
}
