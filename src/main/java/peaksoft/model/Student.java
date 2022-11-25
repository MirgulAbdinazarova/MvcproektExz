package peaksoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.StudyFormat;

import javax.persistence.*;


import static javax.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq",
            sequenceName = "student_seq",
            allocationSize = 1)
    private Long id;
//    @NotEmpty(message = "First name should not be empty")
    private String firstName;

//    @NotEmpty(message = "Last name should not be empty")
    private String lastName;

//    @NotEmpty(message = "phone number should not be empty")
    private int phoneNumber;

//    @NotEmpty(message = "Email should not be empty")
//    @Email(message = "Email should be valid")
    private String email;
    private StudyFormat studyFormat;
    @ManyToOne(cascade = {DETACH,REFRESH,MERGE},fetch = FetchType.EAGER)
    private Group group;
}