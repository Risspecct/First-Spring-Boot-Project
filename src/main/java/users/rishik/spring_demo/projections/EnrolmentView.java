package users.rishik.spring_demo.projections;

import java.time.LocalDateTime;

public interface EnrolmentView {
    long getId();
    LocalDateTime getEnrolmentDate();
    StudentView getStudent();
    CourseView getCourse();
}
