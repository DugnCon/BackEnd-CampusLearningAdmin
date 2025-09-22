package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.CourseBuilder;
import com.javaweb.model.dto.CourseModuleDTO;
import com.javaweb.utils.MapUtils;

@Component
public class CourseConverter {
    public CourseBuilder toCourseBuilder(Map<String, Object> maps) {
        return new CourseBuilder.Builder()
                .setCourseID(MapUtils.getObject(maps, "courseId", Long.class))
                .setTitle(MapUtils.getObject(maps, "title", String.class))
                .setDescription(MapUtils.getObject(maps, "description", String.class))
                .setLevel(MapUtils.getObject(maps, "level", String.class))
                .setCategory(MapUtils.getObject(maps, "category", String.class))
                .setLanguage(MapUtils.getObject(maps, "language", String.class))
                .setDuration(MapUtils.getObject(maps, "duration", Integer.class))
                .setCapacity(MapUtils.getObject(maps, "capacity", Integer.class))
                .setPrice(MapUtils.getObject(maps, "price", Double.class))
                .setDiscountPrice(MapUtils.getObject(maps, "discountPrice", Double.class))
                .setRequirements(MapUtils.getObject(maps, "requirements", String.class))
                .setObjectives(MapUtils.getObject(maps, "objectives", String.class))
                .setSyllabus(MapUtils.getObject(maps, "syllabus", String.class))
                .setImageUrl(MapUtils.getObject(maps, "imageUrl", String.class))
                .setVideoUrl(MapUtils.getObject(maps, "videoUrl", String.class))
                .setIsPublished(MapUtils.getObject(maps, "isPublished", Boolean.class))
                .setSlug(MapUtils.getObject(maps, "slug", String.class))
                .setCoursemodules((List<CourseModuleDTO>) maps.get("coursemodules"))
                .build();
    }
}
