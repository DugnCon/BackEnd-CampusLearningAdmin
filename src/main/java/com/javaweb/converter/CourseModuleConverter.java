package com.javaweb.converter;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.CourseModuleBuilder;
import com.javaweb.utils.MapUtils;

@Component
public class CourseModuleConverter {
    public CourseModuleBuilder toCourseModuleBuilder(Map<String,Object> maps) {
        return new CourseModuleBuilder.Builder()
            .setTitle(MapUtils.getObject(maps, "title", String.class))
            .setDescription(MapUtils.getObject(maps, "description", String.class))
            .setVideoUrl(MapUtils.getObject(maps, "videoUrl", String.class))
            .setImageUrl(MapUtils.getObject(maps, "imageUrl", String.class))
            .setDuration(MapUtils.getObject(maps, "duration", Integer.class))
            .setOrderIndex(MapUtils.getObject(maps, "orderIndex", Integer.class))
            .build();
    }
}
