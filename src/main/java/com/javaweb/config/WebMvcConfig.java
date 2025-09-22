package com.javaweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // URL /uploads/** trỏ đến folder OneDrive
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:C:/Users/Admin/OneDrive/Hình ảnh/image/");
    }
}
