package peaksoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;

import static javax.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_seq")
    @SequenceGenerator(name = "instructor_seq",
            sequenceName = "instructor_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
//    @NotEmpty(message = "First name should not be empty")
    private String firstName;

//    @NotEmpty(message = "Last name should not be empty")
    @Column(name = "last_name")
    private String lastName;

//    @NotEmpty(message = "phone number should not be empty")
    @Column(name = "phone_number")
    private int phoneNumber;

//    @NotEmpty(message = "Email should not be empty")
//    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

//    @NotEmpty(message = "Specialization should not be empty")
    @Column(name = "specialization")
    private String specialization;

    @ManyToOne(cascade = {DETACH,REFRESH,MERGE},fetch = FetchType.EAGER)
    private Course course;
}