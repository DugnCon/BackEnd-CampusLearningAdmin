package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.event.EventTechnologiesEntity;
@Repository
public interface IEventTechnologiesRepository extends JpaRepository<EventTechnologiesEntity, Long>{
	@Query("select et from EventTechnologiesEntity et join fetch et.eventTechnology where et.eventTechnology.EventID = :eventId")
	List<EventTechnologiesEntity> findByEventId(@Param("eventId") Long eventId);
}
