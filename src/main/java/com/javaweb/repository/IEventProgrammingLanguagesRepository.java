package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javaweb.entity.event.EventPrizesEntity;
import com.javaweb.entity.event.EventProgrammingLanguagesEntity;

public interface IEventProgrammingLanguagesRepository extends JpaRepository<EventProgrammingLanguagesEntity, Long> {
	@Query("select epl from EventProgrammingLanguagesEntity epl join fetch epl.eventLanguage where epl.eventLanguage.EventID = :eventId")
	List<EventProgrammingLanguagesEntity> findByEventId(@Param("eventId") Long eventId);
}
