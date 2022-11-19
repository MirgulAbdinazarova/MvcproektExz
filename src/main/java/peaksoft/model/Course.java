package peaksoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @SequenceGenerator(name = "course_seq",
            sequenceName = "course_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "course_name",length = 50000 )
    private String courseName;
    @Column(name = "duration",length = 50000 )
    private int duration;
    @Column(name = "discription",length = 50000 )
    private String description;

    @ManyToOne(cascade = {DETACH,REFRESH,MERGE},fetch = FetchType.EAGER)
      private Company company;

//    @ManyToMany(cascade = ALL,fetch = FetchType.EAGER,mappedBy = "courses")
//   private List<Group> groups;

}