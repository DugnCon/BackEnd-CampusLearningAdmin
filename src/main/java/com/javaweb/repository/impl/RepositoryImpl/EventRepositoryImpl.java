package com.javaweb.repository.impl.RepositoryImpl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javaweb.entity.event.EventEntity;
import com.javaweb.repository.impl.EventRepositoryCustom.EventRepositoryCustom;

@Repository
public class EventRepositoryImpl implements EventRepositoryCustom{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<Map<String,Object>> getAllEvent() {
		String sql = "select EventID, Title, EventDate, Location, Category, MaxAttendees, CurrentAttendees, Price, Status from events where 1=1";
		Query qr = entityManager.createNativeQuery(sql);
		qr.unwrap(org.hibernate.query.NativeQuery.class)
		  .setResultTransformer(org.hibernate.transform.AliasToEntityMapResultTransformer.INSTANCE);

		List<Map<String, Object>> list = qr.getResultList();
		return list;
	}

}
