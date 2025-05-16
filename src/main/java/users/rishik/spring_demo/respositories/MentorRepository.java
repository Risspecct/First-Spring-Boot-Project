package users.rishik.spring_demo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import users.rishik.spring_demo.entities.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
