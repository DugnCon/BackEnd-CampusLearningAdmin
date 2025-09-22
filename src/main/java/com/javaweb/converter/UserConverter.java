package com.javaweb.converter;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.UserBuilder;
import com.javaweb.utils.MapUtils;

@Component
public class UserConverter {
	public UserBuilder toUserConverter(Map<String,Object> maps) {
		return new UserBuilder.Builder()
				.setLockDuration(MapUtils.getObject(maps, "duration", Integer.class))
				.setLockReason(MapUtils.getObject(maps, "reason", String.class))
				.setUsername(MapUtils.getObject(maps, "username", String.class))
				.setEmail(MapUtils.getObject(maps, "email", String.class))
				.setFullName(MapUtils.getObject(maps, "fullName", String.class))
				.setDateOfBirth(MapUtils.getObject(maps, "dateOfBirth", String.class))
				.setSchool(MapUtils.getObject(maps, "school", String.class))
				.setRole(MapUtils.getObject(maps, "role", String.class))
				.setStatus(MapUtils.getObject(maps, "status", String.class))
				.setAccountStatus(MapUtils.getObject(maps, "accountStatus", String.class))
				.build();
	}
}
