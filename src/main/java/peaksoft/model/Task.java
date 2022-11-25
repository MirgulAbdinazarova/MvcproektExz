package peaksoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


import static javax.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(name = "task_seq",
            sequenceName = "task_seq",
            allocationSize = 1)
    private Long id;
//     @NotEmpty(message = "Task name should not be empty")
    private String taskName;

//    @NotEmpty(message = "Task text should not be empty")
    private String taskText;

//    @NotEmpty(message = "Deadline should not be empty")
    private int deadline;
    @ManyToOne(cascade ={DETACH,REFRESH,MERGE},fetch = FetchType.EAGER)
    private Lesson lesson;
}