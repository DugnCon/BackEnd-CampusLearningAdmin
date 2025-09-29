package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.event.EventScheduleEntity;
@Repository
public interface IEventScheduleRepository extends JpaRepository<EventScheduleEntity, Long> {
	@Query("select es from EventScheduleEntity es join fetch es.eventSchedule where es.eventSchedule.EventID = :eventId")
	List<EventScheduleEntity> findByEventId(@Param("eventId") Long eventId);
}
