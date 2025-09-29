package com.javaweb.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.entity.Course.CourseEntity;
import com.javaweb.entity.Course.CourseModuleEntity;
import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.dto.CourseModuleDTO;
import com.javaweb.repository.ICourseModuleRepository;
import com.javaweb.repository.ICourseRepository;
import com.javaweb.repository.impl.CourseRepositoryCustom.CourseRepositoryCustom;
import com.javaweb.service.FileStorageService;
import com.javaweb.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;
    
    @Autowired
    private CourseRepositoryCustom courseRepositoryCustom;

    @Autowired
    private ICourseModuleRepository courseModuleRepository;
    
    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private ModelMapper modelMapper;
    
    //Lấy toàn bộ khóa course
    @Override
	public ResponseEntity<Object> getAllCourse() {
		List<Map<String,Object>> listCourse = courseRepositoryCustom.getAllCourse();
		if(listCourse != null) {
			return ResponseEntity.ok().body(
				Map.of(
				"status","Got Successfully!",
				"courses", listCourse
				)
			);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		}
	}

    @Override
    @Transactional
    public ResponseEntity<Object> createCourse(CourseDTO courseDTO) {
        CourseEntity courseEntity = modelMapper.map(courseDTO, CourseEntity.class);

        // Chỉ lưu Course, không thêm module
        courseRepository.save(courseEntity);

        return ResponseEntity.ok(Map.of(
            "status", "success",
            "courseId", courseEntity.getCourseID(),
            "message", "Course created successfully"
        ));
    }
    
    /**
     * 
     * Fix lỗi thêm ảnh: OK
     * 
     * **/
    @Override
    public ResponseEntity<Object> uploadCourseImage(Long courseId, MultipartFile image) {
        CourseEntity course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("status", "error", "message", "Course not found"));
        }

        if (image == null || image.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("status", "error", "message", "No file provided"));
        }

        try {
            String imageUrl = fileStorageService.saveFile(image);
            course.setImageUrl(imageUrl); // set URL trước khi save
            courseRepository.save(course);
            return ResponseEntity.ok(Map.of("status", "success", "message", "Course image uploaded", "imageUrl", imageUrl));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("status", "error", "message", "Failed to save file"));
        }
    }
    
    
    //Xử lý lưu video cho course
    @Override
	public ResponseEntity<Object> uploadCourseVideo(Long courseId, MultipartFile video) {
    	CourseEntity course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("status", "error", "message", "Course not found"));
        }

        if (video == null || video.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("status", "error", "message", "No file provided"));
        }

        try {
            String videoUrl = fileStorageService.saveFile(video);
            course.setImageUrl(videoUrl); // set URL trước khi save
            courseRepository.save(course);
            return ResponseEntity.ok(Map.of("status", "success", "message", "Course image uploaded", "videoUrl", videoUrl));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("status", "error", "message", "Failed to save file"));
        }
	}

    
    @Override
    public ResponseEntity<Object> createModule(Long courseId, CourseModuleDTO moduleDTO) {
        CourseEntity course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("status", "error", "message", "Course not found"));
        }
        CourseModuleEntity module = modelMapper.map(moduleDTO, CourseModuleEntity.class);
        						
        module.setCourses(course);//Lưu course để map tới id của nó

        courseModuleRepository.save(module);

        return ResponseEntity.ok(Map.of("status", "success", "moduleId", module.getModuleID()));
    }


    @Override
    public ResponseEntity<Object> uploadModuleVideoUrl(Long moduleId, String videoUrl) {
        CourseModuleEntity module = courseModuleRepository.findById(moduleId).orElse(null);
        if (module == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("status", "error", "message", "Module not found"));
        }

        module.setVideoUrl(videoUrl);
        courseModuleRepository.save(module);

        return ResponseEntity.ok(Map.of("status", "success", "message", "Module video URL updated"));
    }
    
    /**
     * Xử lý khi mà đã thêm các dạng thông tin text vào trước nhàm 
     * tối ưu hơn + gọi thêm ở api khác nhàm mã giản hơn
     * **/
    @Override
    public ResponseEntity<Object> uploadModuleImage(Long moduleId, MultipartFile image) {
        CourseModuleEntity module = courseModuleRepository.findById(moduleId).orElse(null);
        if (module == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("status", "error", "message", "Module not found"));
        }

        // Lưu ảnh module (tương tự course image)
        try {
			module.setImageUrl(fileStorageService.saveFile(image));
			courseModuleRepository.save(module);
			return ResponseEntity.ok(Map.of("status", "success", "message", "Module image uploaded"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        courseModuleRepository.save(module);
        return ResponseEntity.ok(Map.of("status", "success", "message", "Module image uploaded"));
    }
	
	//Lấy khóa học để xem trước
	@Override
	public ResponseEntity<Object> getCoursePreview(Long courseID) {
		Map<String,Object> courseEntity = courseRepositoryCustom.getCoursePreview(courseID);
		if(courseEntity != null) {
			return ResponseEntity.ok().body(courseEntity);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", HttpStatus.INTERNAL_SERVER_ERROR.value()));
		}
	}
}
