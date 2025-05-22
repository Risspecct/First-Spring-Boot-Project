package users.rishik.spring_demo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.rishik.spring_demo.entities.Course;
import users.rishik.spring_demo.projections.CourseView;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Course, Long> {
    List<CourseView> findByMentorId(long mentorId);

    List<CourseView> findAllBy();
}
