package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.entity.user.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

}
