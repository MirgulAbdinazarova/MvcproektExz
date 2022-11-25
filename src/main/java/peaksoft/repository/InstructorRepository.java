package peaksoft.repository;

import peaksoft.model.Group;
import peaksoft.model.Instructor;
import peaksoft.model.Student;

import java.io.IOException;
import java.util.List;

public interface InstructorRepository {

    void assignInstructorToCourse(Long instructorId,Long courseId) throws IOException;

    List<Instructor> getAllInstructors(Long id);

    void saveInstructor(Instructor instructor,Long id);

    void updateInstructor(Instructor instructor,Long id);

    void deleteInstructorById(Long id);

    Instructor getInstructorById(Long id);
}
