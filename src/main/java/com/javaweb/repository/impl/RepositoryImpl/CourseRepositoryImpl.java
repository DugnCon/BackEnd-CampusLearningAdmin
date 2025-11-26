package com.javaweb.repository.impl.RepositoryImpl;

import com.javaweb.repository.impl.CourseRepositoryCustom.CourseRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class CourseRepositoryImpl implements CourseRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;
	
	//Lấy tất cả các khóa học
	@Override
	public List<Map<String, Object>> getAllCourse() {
	    String sql = "select CourseID, Title, Category, Level, Price, Status, IsPublished from courses where 1=1";
	    Query qr = entityManager.createNativeQuery(sql);

	    List<Object[]> results = qr.getResultList();
	    List<Map<String, Object>> mappedResults = new ArrayList<>();

	    List<String> columns = List.of("CourseID", "Title", "Category", "Level", "Price", "Status", "IsPublished");

	    for (Object[] row : results) {
	        Map<String, Object> map = new HashMap<>();
	        for (int i = 0; i < columns.size(); i++) {
	            map.put(columns.get(i), row[i]);
	        }
	        mappedResults.add(map);
	    }

	    return mappedResults;
	}
	
	//Lấy khóa học cho xem trước
	@SuppressWarnings("deprecation")
	@Override
	public Map<String, Object> getCoursePreview(Long courseId) {
	    String str = "SELECT CourseID, Title, Description, Level, Category, Language, Duration, " +
	                 "Capacity, Price, DiscountPrice, Requirements, Objectives, " +
	                 "UpdatedAt, Syllabus, ImageUrl, VideoUrl, IsPublished " +
	                 "FROM courses WHERE CourseID = :courseId";
	                 
	    Query qr = entityManager.createNativeQuery(str);
	    qr.setParameter("courseId", courseId);
	    
	    //Dùng để chuyển sang map 
	    qr.unwrap(org.hibernate.query.NativeQuery.class)
	      .setResultTransformer(org.hibernate.transform.AliasToEntityMapResultTransformer.INSTANCE);
	    
	    @SuppressWarnings("unchecked")
		Map<String, Object> result = (Map<String, Object>) qr.getSingleResult();
	    return result;
	}

	@Override
	public List<Map<String, Object>> getCourseModule(Long courseId) {
		String sql = "select ModuleID, Title, Description, VideoUrl,"
				+ " ImageUrl, OrderIndex, Duration, UpdatedAt"
				+ " from coursemodules where CourseID = :courseId";
		
		Query qr = entityManager.createNativeQuery(sql)
	            .unwrap(org.hibernate.query.NativeQuery.class)
	            .setResultTransformer(org.hibernate.transform.AliasToEntityMapResultTransformer.INSTANCE);

	    qr.setParameter("courseId", courseId);
		return qr.getResultList();
	}

	@Override
	public List<Map<String, Object>> getCourseModulePreview(Long moduleId) {
		String sql = "select ModuleID, Title, Description, VideoUrl,"
				+ " ImageUrl, OrderIndex, Duration"
				+ " from coursemodules where ModuleID = :moduleId";
		
		Query qr = entityManager.createNativeQuery(sql)
	            .unwrap(org.hibernate.query.NativeQuery.class)
	            .setResultTransformer(org.hibernate.transform.AliasToEntityMapResultTransformer.INSTANCE);

	    qr.setParameter("moduleId", moduleId);
		return qr.getResultList();
	}
}
