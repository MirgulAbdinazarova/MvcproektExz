package peaksoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
    @SequenceGenerator(name = "company_seq",
            sequenceName = "company_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String companyName;
     @Column(name="country")
    private String locatedCountry;

    @OneToMany(cascade = {DETACH,MERGE,REFRESH,PERSIST,REMOVE}, fetch = FetchType.LAZY,mappedBy ="company")
    private List<Course> courses;

    public void addCourse(Course course){
        if(courses==null){
            courses=new ArrayList<>();
        }
        courses.add(course);
    }
}