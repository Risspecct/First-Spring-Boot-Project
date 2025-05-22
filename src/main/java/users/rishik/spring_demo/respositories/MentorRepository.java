package users.rishik.spring_demo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.rishik.spring_demo.entities.Mentor;
import users.rishik.spring_demo.projections.MentorView;

import java.util.List;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    List<MentorView> getAllBy();
}
