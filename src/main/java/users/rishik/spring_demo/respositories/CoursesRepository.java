package users.rishik.spring_demo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import users.rishik.spring_demo.entities.Course;
import users.rishik.spring_demo.projections.CourseView;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Course, Long> {
    public List<CourseView> findByMentorId(long mentorId);
}
