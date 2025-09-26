package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.event.EventTechnologiesEntity;

public interface IEventTechnologiesRepository extends JpaRepository<EventTechnologiesEntity, String>{

}
