package users.rishik.spring_demo.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "student") //Optional because otherwise it takes class name as table name
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //There are different types of strategies
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String fname;

    @Column(name = "last_name", nullable = false)
    private String lname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter and Setter for fname
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    // Getter and Setter for lname
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}

