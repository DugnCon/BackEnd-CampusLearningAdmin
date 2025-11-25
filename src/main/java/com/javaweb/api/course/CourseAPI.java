package com.javaweb.api.course;

import com.javaweb.builder.CourseBuilder;
import com.javaweb.builder.CourseModuleBuilder;
import com.javaweb.converter.CourseConverter;
import com.javaweb.converter.CourseModuleConverter;
import com.javaweb.entity.Course.CourseLessonsEntity;
import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.dto.CourseLessonsDTO;
import com.javaweb.model.dto.CourseModuleDTO;
import com.javaweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping
public class CourseAPI {

    @Autowired
    private ICourseService courseService;
    @Autowired
    private ICourseServiceEdit courseEditService;
    @Autowired
    private ICourseServiceEdit courServiceEdit;
    @Autowired
    private ICourseModuleServiceEdit courseModuleServiceEdit;
    @Autowired
    private CourseConverter courseConverter;
    @Autowired
    private CourseModuleConverter courseModuleConverter;
    @Autowired
    private ICourseLessonService courseLessonService;
    @Autowired
    private VideoChunkService videoChunkService;
    @Autowired
    private FileStorageService fileStorageService;

    // tạo khóa học
    @PostMapping("/courses")
    public ResponseEntity<Object> createCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }
    
  //Lấy danh sách khóa học
    @GetMapping("/courses")
    public ResponseEntity<Object> getListCourse() {
    	return courseService.getAllCourse();
    }
    
    //Xem trước khóa học
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Object> getCoursePreview(@PathVariable Long courseId) {
    	return courseService.getCoursePreview(courseId);
    }
    
    /*@GetMapping("/courses/{courseId}/edit")
    public ResponseEntity<Object> getCourseEditPreview(@PathVariable Long courseId) {
    	return courseService.getCourseEditPreview(courseId);
    }*/
    
    //Xem truoc module khoa hoc
    @GetMapping("/courses/{courseId}/modules")
    public ResponseEntity<Object> getCourseModulePreview(@PathVariable Long courseId) {
    	return courseModuleServiceEdit.getCoureModule(courseId);
    }
    
    @GetMapping("/modules/{moduleId}/lessons") 
    public ResponseEntity<Object> getCourseLessonsPreview(@PathVariable Long moduleId) {
    	return courseLessonService.getAllCourseLesson(moduleId);
    }
    
    //edit khóa học
    @PutMapping("/courses/{courseId}")
    public ResponseEntity<Object> updateCourse(@PathVariable Long courseId,@RequestBody Map<String,Object> courseData) {
    	CourseBuilder courseBuilder =  courseConverter.toCourseBuilder(courseData);
    	courseBuilder.setCourseID(courseId);
    	return courseEditService.updateCourse(courseBuilder);
    }
    
    //Xem chi tiêts module
    @GetMapping("/courses/{courseId}/modules/{moduleId}")
    public ResponseEntity<Object> getCourseInPreview(@PathVariable Long courseId, @PathVariable Long moduleId) {
    	return courseModuleServiceEdit.getCoureModulePreview(moduleId);
    }
    
    //edit module cuả khóa học
    @PutMapping("/courses/{courseId}/modules/{moduleId}")
    public ResponseEntity<Object> updateCourseModule(@PathVariable Long courseId,  @PathVariable Long moduleId,@RequestBody Map<String,Object> moduleData) {
    	CourseModuleBuilder courseModuleBuilder = courseModuleConverter.toCourseModuleBuilder(moduleData);
    	return courseModuleServiceEdit.updateCoureModule(courseModuleBuilder, courseId, moduleId);
    }

    // upload ảnh khóa học
    @PostMapping("/courses/{courseId}/image")
    @Async
    public ResponseEntity<Object> uploadCourseImage(
            @PathVariable Long courseId,
            @RequestParam("image") MultipartFile image) {
        return courseService.uploadCourseImage(courseId, image);
    }

    // upload video khóa học
    /*@PostMapping("/courses/{courseId}/video")
    @Async
    public ResponseEntity<Object> uploadCourseVideo(
            @PathVariable Long courseId,
            @RequestParam("video") MultipartFile video) {
        return courseService.uploadCourseVideo(courseId, video);
    }*/

    // tạo module
    @PostMapping("/courses/{courseId}/modules")
    public ResponseEntity<Object> createModule(
            @PathVariable Long courseId,
            @RequestBody CourseModuleDTO moduleDTO) {
        return courseService.createModule(courseId, moduleDTO);
    }

    //upload video cho module
    @PostMapping("/modules/{moduleId}/video-url")
    @Async
    public ResponseEntity<Object> uploadModuleVideoUrl(
            @PathVariable Long moduleId,
            @RequestBody CourseModuleDTO moduleDTO) {
        return courseService.uploadModuleVideoUrl(moduleId, moduleDTO.getVideoUrl());
    }

    // upload ảnh cho module
    @PostMapping("/modules/{moduleId}/image")
    @Async
    public ResponseEntity<Object> uploadModuleImage(
            @PathVariable Long moduleId,
            @RequestParam("image") MultipartFile image) {
        return courseService.uploadModuleImage(moduleId, image);
    }
    
    // xóa khóa học
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Long courseId) {
    	return courseEditService.deleteCourse(courseId);
    }
    
    //Xóa module
    @DeleteMapping("/courses/{courseId}/modules/{moduleId}")
    public ResponseEntity<Object> deleteModule(@PathVariable Long courseId, @PathVariable Long moduleId) {
    	return courseModuleServiceEdit.deleteCoureModule(courseId, moduleId);
    }
    
  //Đưa dữ liệu Lesson
    @GetMapping("/courses/{courseId}/modules/{moduleId}/lessons")
    public ResponseEntity<Object> getCourseLesson(@PathVariable Long courseId, @PathVariable Long moduleId) {
    	return courseLessonService.getAllCourseLesson(moduleId);
    }
    
    //Thêm bài học
    @PostMapping("/courses/{courseId}/modules/{moduleId}/lessons")
    public ResponseEntity<Object> createCourseLesson(@PathVariable Long courseId, @PathVariable Long moduleId,@RequestBody CourseLessonsDTO courseLessonsDTO) {
    	return courseLessonService.insertCourseLesson(moduleId, courseLessonsDTO);
    }
    
  //Đưa dữ liệu Lesson
    @GetMapping("/courses/{courseId}/modules/{moduleId}/lessons/{lessonId}")
    public CourseLessonsEntity getPreviewCourseLesson(@PathVariable Long courseId, @PathVariable Long moduleId, @PathVariable Long lessonId) {
    	return courseLessonService.getSingleCourseLesson(lessonId);
    }
    
    //Xóa lesson
    @DeleteMapping("/courses/{courseId}/modules/{moduleId}/lessons/{lessonId}")
    public ResponseEntity<Object> deleteModuleLesson(@PathVariable Long courseId, @PathVariable Long moduleId , @PathVariable Long lessonId) {
    	return courseLessonService.deleteCourseLesson(lessonId);
    }
    
    //Update lesson
    @PutMapping("/courses/{courseId}/modules/{moduleId}/lessons/{lessonId}")
    public ResponseEntity<Object> updateModuleLesson(@PathVariable Long courseId, @PathVariable Long moduleId , @PathVariable Long lessonId, @RequestBody CourseLessonsDTO courseLessonsDTO) {
    	return courseLessonService.updateCourseLesson(lessonId, courseLessonsDTO);
    }
    
    @PostMapping("/courses/{courseId}/publish")
    public ResponseEntity<Object> updatePulished(@PathVariable Long courseId) {
    	return courseService.updatePublished(courseId);
    }

    @PostMapping("/courses/{courseId}/video-chunk")
    public ResponseEntity<?> uploadVideoChunk(
            @PathVariable Long courseId,
            @RequestParam("video") MultipartFile chunk,
            @RequestParam("chunkIndex") Integer chunkIndex,
            @RequestParam("totalChunks") Integer totalChunks,
            @RequestParam("fileName") String fileName) {

        Map<String, Object> result = videoChunkService.processVideoChunk(
                courseId, chunk, chunkIndex, totalChunks, fileName
        );

        boolean success = (boolean) result.get("success");
        return success ?
                ResponseEntity.ok(result) :
                ResponseEntity.badRequest().body(result);
    }

    /**
     * API finalize video upload
     */
    /*@PostMapping("/courses/{courseId}/video-finalize")
    public ResponseEntity<?> finalizeVideoUpload(
            @PathVariable Long courseId,
            @RequestParam("fileName") String fileName,
            @RequestParam("totalChunks") Integer totalChunks) {

        Map<String, Object> result = videoChunkService.finalizeVideoUpload(
                courseId, fileName, totalChunks
        );

        boolean success = (boolean) result.get("success");
        return success ?
                ResponseEntity.ok(result) :
                ResponseEntity.badRequest().body(result);
    }*/

    /**
     * API cleanup temp files
     */
    @PostMapping("/courses/cleanup-temp-files")
    public ResponseEntity<?> cleanupTempFiles() {
        Map<String, Object> result = videoChunkService.cleanupOldTempFiles();

        boolean success = (boolean) result.get("success");
        return success ?
                ResponseEntity.ok(result) :
                ResponseEntity.badRequest().body(result);
    }
}
