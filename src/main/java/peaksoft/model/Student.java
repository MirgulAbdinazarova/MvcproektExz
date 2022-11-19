package peaksoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.StudyFormat;

import javax.persistence.*;

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

    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;
    private StudyFormat studyFormat;
}