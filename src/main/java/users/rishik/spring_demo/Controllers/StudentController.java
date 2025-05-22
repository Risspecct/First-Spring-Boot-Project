package users.rishik.spring_demo.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.rishik.spring_demo.dto.StudentDto;
import users.rishik.spring_demo.entities.Student;
import users.rishik.spring_demo.exceptions.NotFoundException;
import users.rishik.spring_demo.projections.StudentView;
import users.rishik.spring_demo.services.StudentService;

import java.util.List;
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

    @PostMapping("/addAll")
    public ResponseEntity<?> addAllStudents(@RequestBody @Valid List<@Valid Student> students){
        try{
            return ResponseEntity.ok(this.studentService.addAllStudents(students));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(Map.of("Message", e.getMessage()));
        }
    }

    @GetMapping("/find/{sid}")
    public ResponseEntity<?> getStudentById(@PathVariable(name="sid") long StudentId) {
        try {
            Student student = this.studentService.getStudentById(StudentId);
            return ResponseEntity.ok(student);
        } catch (NotFoundException e) {
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
    public ResponseEntity<?> updateStudent(@PathVariable long studentId, @Valid @RequestBody StudentDto student)
    {
        try {
            Student updatedStudent = this.studentService.updateStudent(student, studentId);
            return ResponseEntity.ok(updatedStudent);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(Map.of("Message", e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception a) {
            return ResponseEntity.internalServerError().body(Map.of("Error", a.getMessage()));
        }
    }

    @GetMapping("/find/all")
    public ResponseEntity<?> getAllStudents(){
        try {
            List<StudentView> students = this.studentService.getAllStudents();
            if (students.isEmpty()) return new ResponseEntity<>(Map.of("Error", "No students found in database"), HttpStatus.NOT_FOUND);
            else return ResponseEntity.ok(students);
        } catch (Exception a) {
            return ResponseEntity.internalServerError().body(Map.of("Error", a.getMessage()));
        }
    }
}
