package users.rishik.spring_demo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.rishik.spring_demo.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{

}
