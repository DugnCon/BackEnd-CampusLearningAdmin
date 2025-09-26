package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.entity.event.EventPrizesEntity;

public interface IEventPrizesRepository extends JpaRepository<EventPrizesEntity, Long>{

}
