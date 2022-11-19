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
@Table(name = "grouppa")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
    @SequenceGenerator(name = "group_seq",
            sequenceName = "group_seq",
            allocationSize = 1)
    private Long id;

    private String groupName;
    private String dateOfStart;
    private String image;

    @ManyToMany(cascade = {DETACH,MERGE,REFRESH},fetch = FetchType.LAZY)
    @JoinTable(name = "groups_courses",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;
}