package peaksoft.repository.repoImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Group;
import peaksoft.model.Student;
import peaksoft.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void assignStudentToGroup(Long studentId, Long groupId) {
     Student student= entityManager.find(Student.class,studentId);
     Group group= entityManager.find(Group.class,groupId);
      student.setGroup(group);
      group.getStudents().add(student);
      entityManager.merge(student);
      entityManager.merge(group);
    }

    @Override
    public List<Student> getAllStudents(Long id) {
        return entityManager.createQuery("select s from Student s where s.group.id=:id", Student.class).
                setParameter("id",id).getResultList();
    }

    @Override
    public void saveStudent(Student student, Long id) {
    Group group = entityManager.find(Group.class,id);
    group.addStudent(student);
    student.setGroup(group);
    entityManager.merge(student);
    }

    @Override
    public void updateStudent(Student student, Long id) {
    Student student1 = entityManager.find(Student.class,id);
    student1.setFirstName(student.getFirstName());
    student1.setLastName(student.getLastName());
    student1.setPhoneNumber(student.getPhoneNumber());
    student1.setEmail(student.getEmail());
    entityManager.merge(student1);

    }

    @Override
    public void deleteStudentById(Long id) {
    entityManager.remove(entityManager.find(Student.class,id));
    }

    @Override
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class,id);
    }


}
