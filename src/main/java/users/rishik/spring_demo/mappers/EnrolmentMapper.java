package users.rishik.spring_demo.mappers;

import org.springframework.stereotype.Component;
import users.rishik.spring_demo.dto.EnrolmentDto;
import users.rishik.spring_demo.entities.Course;
import users.rishik.spring_demo.entities.Enrolment;
import users.rishik.spring_demo.entities.Student;
import users.rishik.spring_demo.exceptions.NotFoundException;
import users.rishik.spring_demo.respositories.CoursesRepository;
import users.rishik.spring_demo.respositories.StudentRepository;

@Component
public class EnrolmentMapper {
    private final StudentRepository studentRepository;
    private final CoursesRepository coursesRepository;

    public EnrolmentMapper(StudentRepository studentRepository, CoursesRepository coursesRepository){
        this.studentRepository = studentRepository;
        this.coursesRepository = coursesRepository;
    }

    public Enrolment mapToModel(EnrolmentDto dto){
        Student student = studentRepository.findById(dto.getStudentId()).orElseThrow(()-> new NotFoundException("Student with id: " + dto.getStudentId() + " not found"));
        Course course = coursesRepository.findById(dto.getCourseId()).orElseThrow(()-> new NotFoundException("Course with id: " + dto.getCourseId() + " not found"));
        Enrolment enrolment = new Enrolment();
        enrolment.setCourse(course);
        enrolment.setEnrolmentDate(dto.getEnrolmentDate());
        enrolment.setStudent(student);
        enrolment.setStatus(dto.getStatus());
        return enrolment;
    }
}
