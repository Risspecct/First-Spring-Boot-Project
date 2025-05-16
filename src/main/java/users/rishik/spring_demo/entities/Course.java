package users.rishik.spring_demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Courses")
@Setter
@Getter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", nullable = false)
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="price", nullable = false)
    private double price;

    @Column(name="capacity", nullable = false)
    private int capacity;

    @Column(name="No_Of_Days", nullable = false)
    private int noOfDays;

    @Column(name = "Start_Date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false, referencedColumnName = "Id")
    private Mentor mentor;

    @Column(name = "End_Date", nullable = false)
    private LocalDateTime endDate;

    @PrePersist
    public void getEndDate(){
        this.endDate =  this.startDate.plusDays(this.noOfDays);
    }
}
