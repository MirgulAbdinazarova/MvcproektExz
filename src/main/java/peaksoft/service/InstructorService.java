package peaksoft.service;

import peaksoft.model.Instructor;

import java.util.List;

public interface InstructorService {

    void assignInstructorToCourse(Long instructorId,Long courseId);

    List<Instructor> getAllInstructors(Long id);

    void saveInstructor(Instructor instructor,Long id);

    void updateInstructor(Instructor instructor,Long id);

    void deleteInstructorById(Long id);

    Instructor getInstructorById(Long id);
}
