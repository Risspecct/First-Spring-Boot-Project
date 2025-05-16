package users.rishik.spring_demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import users.rishik.spring_demo.entities.Mentor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CourseDto {
    private String name;

    private double price;

    private int capacity;

    private int noOfDays;

    private LocalDateTime startDate;

    private String description;

    private long mentorId;

}
