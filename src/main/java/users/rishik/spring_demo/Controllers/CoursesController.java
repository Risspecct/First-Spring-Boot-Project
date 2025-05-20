package users.rishik.spring_demo.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.rishik.spring_demo.dto.CourseDto;
import users.rishik.spring_demo.entities.Course;
import users.rishik.spring_demo.exceptions.NotFoundException;
import users.rishik.spring_demo.mappers.CourseMapper;
import users.rishik.spring_demo.services.CoursesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    private final CoursesService coursesService;
    private final CourseMapper courseMapper;

    @Autowired
    public CoursesController(CoursesService coursesService, CourseMapper courseMapper) {
        this.coursesService = coursesService;
        this.courseMapper = courseMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid CourseDto courseDto){
        try {
            Course course = this.courseMapper.mapToModel(courseDto);
            return new ResponseEntity<>(this.coursesService.addCourse(course), HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(Map.of("Error", e.getMessage()));
        }
    }


    @PostMapping("/addAll")
    public ResponseEntity<?> addAllCourses(@RequestBody @Valid List<CourseDto> courseDtos){
        try {
            List<Course> courses = new ArrayList<>();
            for (CourseDto courseDto : courseDtos) {
                courses.add(this.courseMapper.mapToModel(courseDto));
            }
            return new ResponseEntity<>(this.coursesService.addAllCourses(courses), HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(Map.of("Error", e.getMessage()));
        }
    }
    @GetMapping("/find/{courseId}")
    public ResponseEntity<?> findCourseById(@PathVariable long courseId){
        try {
            return ResponseEntity.ok(this.coursesService.getcourse(courseId));
        } catch (NotFoundException e){
            return new ResponseEntity<>(Map.of("Error", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<?>  deleteById(@PathVariable long courseId){
        try {
            this.coursesService.deleteCourse(courseId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity<?> updateCourse(@RequestBody @Valid  CourseDto dto,@PathVariable long courseId){
        try {
            Course course = this.courseMapper.mapToModel(dto);
            return new ResponseEntity<>(this.coursesService.updateCourse(course, courseId), HttpStatus.ACCEPTED);
    } catch (NotFoundException e){
            return new ResponseEntity<>(Map.of("Error", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}