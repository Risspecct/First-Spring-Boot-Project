package users.rishik.spring_demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Mentor")
@Entity
@Setter
@Getter
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id", nullable = false)
    private long id;

    @Column(name = "First_name", nullable = false)
    @NotBlank
    private String firstName;

    @Column(name = "Last_name", nullable = false)
    @NotBlank
    private String lastName;

    @Column(name = "Company", nullable = false)
    @NotBlank
    private String company;

    @Column(name = "Years_of_Experience", nullable = false)
    @Min(0)
    @Max(50)
    private float yearsOfExperience;
}
