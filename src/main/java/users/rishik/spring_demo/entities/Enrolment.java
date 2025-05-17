package users.rishik.spring_demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import users.rishik.spring_demo.enums.EnrolmentStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "enrolments")
public class Enrolment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id", nullable = false)
    private long id;

    @Column(name = "enrolment_date", nullable = false)
    private LocalDateTime enrolmentDate;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "status", nullable = false)
    private EnrolmentStatus status = EnrolmentStatus.ACTIVE;
}
