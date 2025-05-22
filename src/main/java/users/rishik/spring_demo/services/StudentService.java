package users.rishik.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import users.rishik.spring_demo.dto.StudentDto;
import users.rishik.spring_demo.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import users.rishik.spring_demo.entities.Student;
import users.rishik.spring_demo.projections.StudentView;
import users.rishik.spring_demo.respositories.StudentRepository;

import java.util.List;
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

    public List<Student> addAllStudents(List<Student> students){
        return this.studentRepository.saveAll(students);
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

    public Student updateStudent(StudentDto student, long studentId){
        Student existingStudent = this.getStudentById(studentId);
        if (student.getFname() != null) existingStudent.setFname(student.getFname());
        if (student.getLname() != null) existingStudent.setLname(student.getLname());
        if (student.getEmail() != null) existingStudent.setEmail(student.getEmail());
        if (student.getPassword() != null) existingStudent.setPassword(student.getPassword());
        return this.studentRepository.save(existingStudent);
    }

    public List<StudentView> getAllStudents(){
        return this.studentRepository.findAllBy();
    }
}
