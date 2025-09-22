package com.javaweb.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.AdminEntity;

@Repository
public interface IAdminRepositoryLogin extends JpaRepository<AdminEntity, Long> {
	@Procedure(name = "AdminEntity.adminLogin")
	Map<String, Object> adminLogin(@Param("u_identifier") String identifier); 
}
