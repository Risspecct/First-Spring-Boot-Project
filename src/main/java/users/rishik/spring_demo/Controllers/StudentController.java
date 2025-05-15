package users.rishik.spring_demo.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.rishik.spring_demo.entities.Student;
import users.rishik.spring_demo.exceptions.StudentNotFoundException;
import users.rishik.spring_demo.services.StudentService;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student)
    {
        try{
            return ResponseEntity.ok(this.studentService.addStudent(student));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(Map.of("Message", e.getMessage()));
        }
    }

    @GetMapping("/find/{sid}")
    public ResponseEntity<?> getStudentById(@PathVariable(name="sid") long StudentId) {
        try {
            Student student = this.studentService.getStudentById(StudentId);
            return ResponseEntity.ok(student);
        } catch (StudentNotFoundException e) {
            return new ResponseEntity<>(Map.of("Message", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception a) {
            return ResponseEntity.internalServerError().body(Map.of("Error", a.getMessage()));
        }
    }
    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<?> deleteStudentById(@PathVariable long studentId)
    {
        try {
            this.studentService.deleteStudentById(studentId);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(Map.of("Error", e.getMessage()));
        }
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable long studentId, @Valid @RequestBody Student student)
    {
        try {
            Student updatedStudent = this.studentService.updateStudent(student, studentId);
            return ResponseEntity.ok(updatedStudent);
        } catch (StudentNotFoundException e) {
            return new ResponseEntity<>(Map.of("Message", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception a) {
            return ResponseEntity.internalServerError().body(Map.of("Error", a.getMessage()));
        }
    }
}
