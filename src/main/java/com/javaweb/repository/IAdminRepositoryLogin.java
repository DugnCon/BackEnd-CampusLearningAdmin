package com.javaweb.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.AdminEntity;

@Repository
public interface IAdminRepositoryLogin extends JpaRepository<AdminEntity, Long> {
	/*@Procedure(name = "AdminEntity.adminLogin")
	Map<String, Object> adminLogin(@Param("u_identifier") String identifier); */
	@Query("select ad from AdminEntity ad where Email = :email")
	AdminEntity adminLoginByEmail(@Param("email") String email);
	@Query("select ad from AdminEntity ad where Username = :username")
	AdminEntity adminLoginByUsername(@Param("username") String username);
}
