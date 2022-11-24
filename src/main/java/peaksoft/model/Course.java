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

    @ManyToMany(cascade = ALL,mappedBy = "courses",fetch = FetchType.LAZY)
   private List<Group> groups;

    @OneToMany(cascade = ALL,fetch = FetchType.LAZY,mappedBy = "course")
    private List<Instructor>instructors;
    @OneToMany(cascade =ALL,fetch = FetchType.LAZY,mappedBy = "course")
    private List<Lesson>lessons;


    public void addGroup(Group group){
        if(groups==null){
            groups=new ArrayList<>();
        }
        groups.add(group);
    }
    public void addLesson(Lesson lesson){
        if(lessons==null){
            lessons=new ArrayList<>();
        }
        lessons.add(lesson);
    }

    public void addInstructor(Instructor instructor) {
        if(instructors == null) {
            instructors=new ArrayList<>();
        }
        instructors.add(instructor);
    }
}