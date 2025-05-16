package users.rishik.spring_demo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import users.rishik.spring_demo.entities.Course;

public interface CoursesRepository extends JpaRepository<Course, Long> {
}
