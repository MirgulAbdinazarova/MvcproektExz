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
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
    @SequenceGenerator(name = "group_seq",
            sequenceName = "group_seq",
            allocationSize = 1)
    private Long id;

//    @NotEmpty(message = "Group name should not be empty")
    private String groupName;

//    @NotEmpty(message = "start should not be empty")
//    @Positive
    private String dateOfStart;

    private String image;

    @ManyToMany(cascade = {DETACH,REFRESH,MERGE},fetch = FetchType.LAZY)
    @JoinTable(name = "groups_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Course> courses;
    @OneToMany(cascade = ALL,fetch = FetchType.LAZY,mappedBy = "group")
    private List<Student>students;

    public void addCourse(Course course){
        if(courses==null){
            courses=new ArrayList<>();
        }
        courses.add(course);
    }
    public void addStudent(Student student) {
        if(students== null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }
}