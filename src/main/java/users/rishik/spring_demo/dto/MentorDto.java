package users.rishik.spring_demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MentorDto {
    private String firstName;

    private String lastName;

    private String company;

    private float yearsOfExperience;
}
