package com.javaweb.repository;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.event.EventEntity;
import com.javaweb.repository.impl.EventRepositoryCustom.EventRepositoryCustom;

@Repository
public interface IEventRepository extends JpaRepository<EventEntity, Long> {
	@Modifying //Bắt buộc khi query mà không phải select 
	@Transactional
	@Query("UPDATE EventEntity e SET e.status = :status WHERE e.EventID = :eventId")
	int updateEventStatus(@Param("eventId") Long eventId, @Param("status") String status);
}
