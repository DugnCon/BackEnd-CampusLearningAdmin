package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.event.EventPrizesEntity;
import com.javaweb.entity.event.EventScheduleEntity;

@Repository
public interface IEventPrizesRepository extends JpaRepository<EventPrizesEntity, Long>{
	@Query("select es from EventPrizesEntity es join fetch es.eventPrize where es.eventPrize.EventID = :eventId")
	List<EventPrizesEntity> findByEventId(@Param("eventId") Long eventId);
}
