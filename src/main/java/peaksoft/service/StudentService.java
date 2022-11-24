package peaksoft.service;

import peaksoft.model.Student;

import java.util.List;

public interface StudentService {
    void assignStudentToGroup(Long studentId,Long groupId);

    List<Student> getAllStudents(Long id);

    void saveStudent(Student student,Long id);

    void updateStudent(Student student,Long id);

    void deleteStudentById(Long id);

    Student getStudentById(Long id);
}
