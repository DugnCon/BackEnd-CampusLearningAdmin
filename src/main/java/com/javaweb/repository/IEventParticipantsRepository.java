package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.event.EventParticipantsEntity;
import com.javaweb.entity.event.EventScheduleEntity;

@Repository
public interface IEventParticipantsRepository extends JpaRepository<EventParticipantsEntity, Long>{
	@Query("select epe from EventParticipantsEntity epe join fetch epe.eventParticipant where epe.eventParticipant.EventID = :eventId")
	List<EventParticipantsEntity> findByEventId(@Param("eventId") Long eventId);
}
