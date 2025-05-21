package users.rishik.spring_demo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.rishik.spring_demo.entities.Enrolment;
import users.rishik.spring_demo.entities.Course;
import users.rishik.spring_demo.entities.Student;
import users.rishik.spring_demo.enums.EnrolmentStatus;
import users.rishik.spring_demo.projections.EnrolmentView;

import java.util.List;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {

    long countByCourse(Course course);

    List<EnrolmentView> findByStudent(Student student);

    List<EnrolmentView> findByCourseId(long courseId);

    List<EnrolmentView> findByStatusEquals(EnrolmentStatus status);
}
