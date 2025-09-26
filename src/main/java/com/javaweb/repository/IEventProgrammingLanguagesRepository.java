package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.entity.event.EventProgrammingLanguagesEntity;

public interface IEventProgrammingLanguagesRepository extends JpaRepository<EventProgrammingLanguagesEntity, String> {

}
