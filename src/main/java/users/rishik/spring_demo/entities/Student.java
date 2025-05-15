package users.rishik.spring_demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student") //Optional because otherwise it takes class name as table name
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //There are different types of strategies
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First name must not be null")
    private String fname;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Last name must not be null")
    private String lname;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
}

