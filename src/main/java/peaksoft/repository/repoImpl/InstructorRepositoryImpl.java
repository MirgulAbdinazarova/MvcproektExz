package peaksoft.repository.repoImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Course;
import peaksoft.model.Instructor;
import peaksoft.repository.InstructorRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class InstructorRepositoryImpl implements InstructorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        Instructor instructor = entityManager.find(Instructor.class,instructorId);
        Course course = entityManager.find(Course.class,courseId);
        instructor.setCourse(course);
        course.getInstructors().add(instructor);
        entityManager.merge(instructor);
        entityManager.merge(course);
    }

    @Override
    public List<Instructor> getAllInstructors(Long id) {
        return entityManager.createQuery("select i from Instructor i where i.course.id=:id", Instructor.class )
                .setParameter("id",id).getResultList();
    }

    @Override
    public void saveInstructor(Instructor instructor,Long id) {
        Course course = entityManager.find(Course.class,id);
        course.addInstructor(instructor);
        instructor.setCourse(course);
     entityManager.merge(instructor);
    }

    @Override
    public void updateInstructor(Instructor instructor,Long id) {
     Instructor instructor1 = entityManager.find(Instructor.class,id);
     instructor1.setFirstName(instructor.getFirstName());
     instructor1.setLastName(instructor.getLastName());
     instructor1.setEmail(instructor.getEmail());
     instructor1.setPhoneNumber(instructor.getPhoneNumber());
     instructor1.setSpecialization(instructor.getSpecialization());
     entityManager.merge(instructor1);
    }

    @Override
    public void deleteInstructorById(Long id) {
     entityManager.remove(entityManager.find(Instructor.class,id));
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return entityManager.find(Instructor.class,id);
    }
}
