package users.rishik.spring_demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CourseDto {

    @NotBlank
    private String name;

    @NotNull
    private double price;

    @NotNull @Min(8)
    private int capacity;

    @NotNull @Min(3)
    private int noOfDays;

    @NotNull
    private LocalDateTime startDate;

    private String description;

    @NotNull
    private long mentorId;

}
