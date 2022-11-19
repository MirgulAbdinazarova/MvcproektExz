package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Course;
import peaksoft.repository.CourseRepository;
import peaksoft.service.CourseService;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void saveCourse(Course course, Long id) {
        courseRepository.saveCourse(course,id);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public void updateCourse(Course course,Long id) {
     courseRepository.updateCourse(course,id);
    }

    @Override
    public void deleteCourseById(Long id) {
     courseRepository.deleteCourseById(id);
    }
}
