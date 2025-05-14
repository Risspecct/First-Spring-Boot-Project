package users.rishik.spring_demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import users.rishik.spring_demo.entities.Student;
import users.rishik.spring_demo.services.StudentService;

import java.util.Optional;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping("/student/add")
    public Student addStudent(@RequestBody Student student)
    {
        return this.studentService.addStudent(student);
    }

    @GetMapping("/student/find/{sid}")
    public Student getStudentById(@PathVariable(name="sid") long StudentId)
    {
        return this.studentService.getStudentById(StudentId);
    }

    @DeleteMapping("/student/delete/{StudentId}")
    public void deleteStudentById(@PathVariable long StudentId)
    {
        this.studentService.deleteStudentById(StudentId);
    }

    @PutMapping("/student/update/{StudentId}")
    public Student updateStudent(@PathVariable long StudentId, @RequestBody Student student)
    {
        if (StudentId != student.getId()) return null;
        return this.studentService.updateStudent(student);
    }
}
