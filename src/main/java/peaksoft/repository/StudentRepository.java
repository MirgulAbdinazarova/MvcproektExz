package peaksoft.repository;

import peaksoft.model.Group;
import peaksoft.model.Student;

import java.util.List;

public interface StudentRepository {

    void assignStudentToGroup(Long studentId,Long groupId);

     List<Student> getAllStudents(Long id);
     void saveStudent(Student student,Long id);    //group id
     void updateStudent(Student student,Long id);
     void deleteStudentById(Long id);
     Student getStudentById(Long id);
}
