package com.javaweb.repository.impl.RepositoryImpl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javaweb.entity.Course.CourseLessonsEntity;
import com.javaweb.repository.impl.CourseRepositoryEditCustom.CourseLessonRepositoryCustom;
@Repository
public class CourseLessonRepositoryImpl implements CourseLessonRepositoryCustom{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<Map<String, Object>> getAllCourseLesson(Long moduleId) {
		String sql = "select LessonID, Title, Description,OrderIndex, Type,Duration, CreatedAt "
				+ "from courselessons "
				+ "where ModuleID = :moduleId";
		Query qr = entityManager.createNativeQuery(sql)
	            .unwrap(org.hibernate.query.NativeQuery.class)
	            .setResultTransformer(org.hibernate.transform.AliasToEntityMapResultTransformer.INSTANCE);

	    qr.setParameter("moduleId", moduleId);
		return qr.getResultList();
	}
	@Override
	public CourseLessonsEntity getSingleCourseLesson(Long lessonId) {
		// TODO Auto-generated method stub
		return null;
	}

}
