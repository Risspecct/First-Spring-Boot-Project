package users.rishik.spring_demo.projections;

import users.rishik.spring_demo.enums.EnrolmentStatus;

import java.time.LocalDateTime;

public interface EnrolmentView {
    long getId();
    LocalDateTime getEnrolmentDate();
    StudentView getStudent();
    CourseView getCourse();
    EnrolmentStatus getStatus();
}
