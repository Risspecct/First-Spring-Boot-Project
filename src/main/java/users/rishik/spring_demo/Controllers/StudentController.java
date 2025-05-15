package users.rishik.spring_demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import users.rishik.spring_demo.entities.Student;
import users.rishik.spring_demo.services.StudentService;

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
    public Student addStudent(@RequestBody Student student)
    {
        return this.studentService.addStudent(student);
    }

    @GetMapping("/find/{sid}")
    public Student getStudentById(@PathVariable(name="sid") long StudentId)
    {
        return this.studentService.getStudentById(StudentId);
    }

    @DeleteMapping("/delete/{studentId}")
    public void deleteStudentById(@PathVariable long studentId)
    {
        this.studentService.deleteStudentById(studentId);
    }

    @PutMapping("/update/{studentId}")
    public Student updateStudent(@PathVariable long studentId, @RequestBody Student student)
    {
        Student existingStudent = this.getStudentById(studentId);
        if (existingStudent == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        return this.studentService.updateStudent(student, studentId);
    }
}
