package users.rishik.spring_demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.rishik.spring_demo.entities.Course;
import users.rishik.spring_demo.exceptions.NotFoundException;
import users.rishik.spring_demo.services.CoursesService;

import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    private final CoursesService coursesService;

    @Autowired
    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Course course){
        try {
        return new ResponseEntity<>(this.coursesService.addCourse(course), HttpStatus.CREATED);
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

    @DeleteMapping("/delete//{courseId}")
    public ResponseEntity<?>  deleteById(@PathVariable long courseId){
        try {
            this.coursesService.deleteCourse(courseId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}