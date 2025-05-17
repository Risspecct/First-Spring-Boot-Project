package users.rishik.spring_demo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.rishik.spring_demo.entities.Enrolment;
import users.rishik.spring_demo.entities.Course;
import users.rishik.spring_demo.entities.Student;

import java.util.List;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {
//    List<Course> findByCourse(Course course); //Can fetch all the rows with same course automatically

    long countByCourse(Course course);

    List<Enrolment> findByStudent(Student student);
}
