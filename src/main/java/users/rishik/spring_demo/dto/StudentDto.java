package users.rishik.spring_demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDto {

    private String fname;

    private String lname;

    private String email;

    private String password;
}
