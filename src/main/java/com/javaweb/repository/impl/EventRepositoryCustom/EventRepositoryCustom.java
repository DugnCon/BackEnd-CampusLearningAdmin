package com.javaweb.repository.impl.EventRepositoryCustom;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.entity.event.EventEntity;

@Repository
public interface EventRepositoryCustom {
	List<Map<String,Object>> getAllEvent();
}
