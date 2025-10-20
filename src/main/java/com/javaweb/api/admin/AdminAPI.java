package com.javaweb.api.admin;

import com.javaweb.model.dto.AdminDTO;
import com.javaweb.service.IAdminServiceLogin;
import com.javaweb.service.JwtService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AdminAPI {
	@Autowired
	private IAdminServiceLogin adminServiceLogin;
	@Autowired
	private JwtService jwtService;
	//Kiểm tra role và tạo jwt
	@PostMapping("/auth/login")
	public ResponseEntity<Object> adminLogin(@Valid @RequestBody AdminDTO adminDTO) {
		return adminServiceLogin.AdminLogin(adminDTO);
	}
	
	@PostMapping("/auth/logout")
	public ResponseEntity<Object> adminLogout() {
		return null;
	}
	
	//Chỉ cần check sign của jwt mà không cần query
	@GetMapping("/auth/session")
	public ResponseEntity<Object> checkSession(HttpServletRequest request) {
		//Xác định request có kèm token hay không và có chuẩn dạng Authorization: Bearer <jwt_token>
	    String authHeader = request.getHeader("Authorization");
	    
	    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	    	   return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                       .body(Map.of("loggedIn", false, "message", "Token expired"));
	    }
	    
	    String token = authHeader.substring(7);
	    try {
	        // Check token hết hạn chưa
	    	if (jwtService.isTokenExpired(token)) {
	    	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	    	                         .body(Map.of("loggedIn", false, "message", "Token expired"));
	    	}
	        // Lấy claims từ token
	        Claims claims = jwtService.extractAllClaims(token);

	        return ResponseEntity.ok(Map.of(
	            "loggedIn", true,
	            "user", Map.of(
	                "id", claims.get("id"),
	                "identifier", claims.get("identifier"),
	                "role", claims.get("role")
	            )
	        ));
	    }catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("loggedIn", false, "message", "Invalid token"));
	    }

	}
	//Làm mới jwt khi hết hạn
	@PostMapping("/auth/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody Map<String, String> request) {
	    String refreshToken = request.get("refreshToken");

	    if (jwtService.isTokenExpired(refreshToken)) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                             .body(Map.of("error", "Refresh token expired"));
	    }

	    String email = jwtService.extractEmail(refreshToken);

	    // Gen access token mới
	    String newAccessToken = jwtService.generateToken(email);
	    String newRefreshToken = jwtService.generateRefreshToken(email); 

	    return ResponseEntity.ok(Map.of(
	        "token", newAccessToken,
	        "refreshToken", newRefreshToken
	    ));
	}

}
