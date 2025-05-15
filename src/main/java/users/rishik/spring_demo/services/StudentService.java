package users.rishik.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import users.rishik.spring_demo.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import users.rishik.spring_demo.entities.Student;
import users.rishik.spring_demo.respositories.StudentRepository;

import java.util.Optional;

@Service
public class StudentService
{
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public Student getStudentById(long StudentId)
    {
        Optional<Student> optionalVal = this.studentRepository.findById(StudentId);
        return optionalVal.orElseThrow(() -> {
            return new NotFoundException("Student with id: " + StudentId + " not found");
        });
    }

    public void deleteStudentById(long StudentId)
    {
        this.studentRepository.deleteById(StudentId);
    }

    public Student updateStudent(Student student, long studentId){
        Student existingStudent = this.getStudentById(studentId);
        existingStudent.setFname(student.getFname());
        existingStudent.setLname(student.getLname());
        return studentRepository.save(existingStudent);
    }
}
