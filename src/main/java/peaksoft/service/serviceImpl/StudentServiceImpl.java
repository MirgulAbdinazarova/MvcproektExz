package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Student;
import peaksoft.repository.StudentRepository;
import peaksoft.service.StudentService;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void assignStudentToGroup(Long studentId, Long groupId) {
        studentRepository.assignStudentToGroup(studentId,groupId);
    }

    @Override
    public List<Student> getAllStudents(Long id) {
        return studentRepository.getAllStudents(id);
    }

    @Override
    public void saveStudent(Student student, Long id) {
    studentRepository.saveStudent(student,id);
    }

    @Override
    public void updateStudent(Student student, Long id) {
     studentRepository.updateStudent(student,id);
    }

    @Override
    public void deleteStudentById(Long id) {
     studentRepository.deleteStudentById(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }
}
