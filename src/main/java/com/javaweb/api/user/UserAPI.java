package com.javaweb.api.user;

import com.javaweb.builder.UserBuilder;
import com.javaweb.converter.UserConverter;
import com.javaweb.service.IUserService;
import com.javaweb.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class UserAPI {
	@Autowired
	private UserConverter userConverter;
	@Autowired
	private IUserService userService;
	//Hiện các user ra màn
	@GetMapping("/users")
	public ResponseEntity<Object> getUsers() {
		return userService.getAllUser();
	}
	//Chỉnh sửa profile cho các user
	@PutMapping("/users/{userId}")
	public ResponseEntity<Object> updateUsers(@PathVariable Long userId, @RequestBody Map<String,Object> maps) {
		return null;
	}
	//Xóa user
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<Object> deleteUsers(@PathVariable Long userId) {
		return null;
	}
	//Đổi role cho user
	@PutMapping("/users/{userId}/role")
	public ResponseEntity<Object> changeRoleUsers(@PathVariable Long userId,@RequestBody Map<String,Object> maps) {
		String newRole = MapUtils.getObject(maps, "role", String.class);
		return userService.updateRoleUser(userId, newRole);
	}
	//Reset password theo yêu cầu người dùng
	@PostMapping("/users/{userId}/reset-password")
	public ResponseEntity<Object> changePasswordUsers(@PathVariable Long userId) {
		return userService.updatePasswordUser(userId);
	}
	//Khóa tài khoản User
	@PostMapping("/users/{userId}/lock")
	public ResponseEntity<Object> lockAccountUsers(@PathVariable Long userId,@RequestBody Map<String,Object> maps) {
		UserBuilder userBuilder = userConverter.toUserConverter(maps);
		return userService.lockAccountUser(userId, userBuilder);
	}
	@PostMapping("/users/{userId}/unlock")
	public ResponseEntity<Object> unLockAccountUsers(@PathVariable Long userId) {
		return userService.unLockAccountUser(userId);
	}
}

