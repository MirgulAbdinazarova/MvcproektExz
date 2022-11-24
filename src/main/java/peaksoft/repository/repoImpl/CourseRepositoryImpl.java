package peaksoft.repository.repoImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.repository.CourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class CourseRepositoryImpl  implements CourseRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveCourse(Course course, Long id) {
     Company company = entityManager.find(Company.class,id);
     company.addCourse(course);
     course.setCompany(company);
     entityManager.merge(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    public List<Course> getAllCourses(Long id) {
        return entityManager.createQuery("select cs from Course cs where cs.company.id=:id",
                Course.class).setParameter("id",id).getResultList();
    }

    @Override
    public void updateCourse(Course course,Long id) {
       Course course1 = entityManager.find(Course.class,id);
       course1.setCourseName(course.getCourseName());
       course1.setDuration(course.getDuration());
       course1.setDescription(course.getDescription());
     entityManager.merge(course1);
    }

    @Override
    public void deleteCourseById(Long id) {
     entityManager.remove(entityManager.find(Course.class,id));
    }
}
