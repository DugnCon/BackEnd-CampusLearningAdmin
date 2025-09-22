package com.javaweb.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.model.dto.AdminDTO;

@Service
public interface IAdminServiceLogin {
	ResponseEntity<Object> AdminLogin(AdminDTO adminDTO);
}
