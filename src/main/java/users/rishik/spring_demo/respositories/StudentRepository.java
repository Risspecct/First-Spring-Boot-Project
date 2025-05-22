package users.rishik.spring_demo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.rishik.spring_demo.entities.Student;
import users.rishik.spring_demo.projections.StudentView;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<StudentView> findAllBy();
}
