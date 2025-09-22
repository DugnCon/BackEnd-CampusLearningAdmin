package com.javaweb.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaweb.model.dto.AdminDTO;
import com.javaweb.repository.IAdminRepositoryLogin;
import com.javaweb.service.IAdminServiceLogin;
import com.javaweb.service.JwtService;
import com.javaweb.utils.ObjectConfig;

@Service
public class AdminServiceLoginImpl implements IAdminServiceLogin{
	@Autowired
	private ObjectConfig objectConfig;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private IAdminRepositoryLogin adminRepositoryLogin;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public ResponseEntity<Object> AdminLogin(AdminDTO adminDTO) {
	    if (adminDTO == null || adminDTO.getIdentifier() == null || adminDTO.getIdentifier().trim().isEmpty()) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(Map.of("message", "Identifier is required"));
	    }

	    Map<String, Object> admin = adminRepositoryLogin.adminLogin(adminDTO.getIdentifier());
	    if (admin == null || !"success".equals(objectConfig.StringConfig(admin.get("u_result")))) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body(Map.of("message", "Invalid credentials"));
	    }

	    String dbPassword = objectConfig.StringConfig(admin.get("u_password"));
	    if (!passwordEncoder.matches(adminDTO.getPassword(), dbPassword)) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body(Map.of("message", "Invalid credentials"));
	    }

	    Long id = objectConfig.LongConfig(admin.get("u_id"));
	    String username = objectConfig.StringConfig(admin.get("u_username_"));
	    String email = objectConfig.StringConfig(admin.get("u_email_"));
	    String role = objectConfig.StringConfig(admin.get("u_role"));

	    //SInh JWT với ID và EMail
	    String token = jwtService.generateTokenWithClaims(
	        Map.of("id", id, "identifier", adminDTO.getIdentifier(), "role", role)
	    );

	    return ResponseEntity.ok(Map.of(
	        "message", "Login Successfully!",
	        "username", username,
	        "email", email,
	        "role", role,
	        "token", token
	    ));
	}

}
