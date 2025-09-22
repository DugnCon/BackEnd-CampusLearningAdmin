package com.javaweb.service.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaweb.builder.UserBuilder;
import com.javaweb.entity.user.UserEntity;
import com.javaweb.repository.IUserRepository;
import com.javaweb.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private PasswordEncoder passwordEncoder;
	//Lấy tất cả các user hiện ra bảng cho admin
	@Override
	@Transactional
	public ResponseEntity<Object> getAllUser() {
		List<UserEntity> userList = userRepository.findAll();
		return ResponseEntity.ok(Map.of("status", "Got successfully!", "users", userList));
	}
	//Update vai trò cho user
	@Override
	@Transactional
	public ResponseEntity<Object> updateRoleUser(Long userId, String newRole) {
		UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Not found"));
		userEntity.setUserID(userId);
		if(newRole != null && !newRole.isEmpty()) {
			userEntity.setRole(newRole);
		}
		userRepository.save(userEntity);
		return ResponseEntity.ok(Map.of("status", "Saved Successfully!", "role", newRole));
	}
	//Đặt lại mật khẩu cho user
	@Override
	@Transactional
	public ResponseEntity<Object> updatePasswordUser(Long userId) {
		UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Not found"));
		userEntity.setUserID(userId);
		String password = passwordEncoder.encode("123456");
		userEntity.setPassword(password);
		userRepository.save(userEntity);
		return ResponseEntity.ok(Map.of("status", "Saved Successfully!", "newPassword", "123456"));
	}
	@Override
	public ResponseEntity<Object> lockAccountUser(Long userId,UserBuilder userBuilder) {
		UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Not found"));
		if(userBuilder.getLockDuration() != null) {
			userEntity.setLockDuration(userBuilder.getLockDuration());
		}
		if(userBuilder.getLockReason() != null) {
			userEntity.setLockReason(userBuilder.getLockReason());
		}
		userEntity.setAccountStatus("LOCKED");
		userEntity.setUserID(userId);
		userRepository.save(userEntity);
		return ResponseEntity.ok(Map.of("status","Saved Successfully!"));
	}
	@Override
	public ResponseEntity<Object> unLockAccountUser(Long userId) {
		UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Not found"));
		userEntity.setAccountStatus("ACTIVE");
		userRepository.save(userEntity);
		return ResponseEntity.ok(Map.of("status", "Unlock Successfully!"));
	}

}
