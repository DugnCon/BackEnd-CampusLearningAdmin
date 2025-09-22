package com.javaweb.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.builder.UserBuilder;

@Service
public interface IUserService {
	ResponseEntity<Object> getAllUser();
	ResponseEntity<Object> updateRoleUser(Long userId, String newRole);
	ResponseEntity<Object> updatePasswordUser(Long userId);
	ResponseEntity<Object> lockAccountUser(Long userId,UserBuilder userBuilder);
	ResponseEntity<Object> unLockAccountUser(Long userId);
}
