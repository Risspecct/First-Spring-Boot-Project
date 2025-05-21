package users.rishik.spring_demo.projections;

import java.time.LocalDateTime;

public interface CourseView {
    MentorView getMentor();
    Long getId();
    String getName();
    LocalDateTime getStartDate();
}
