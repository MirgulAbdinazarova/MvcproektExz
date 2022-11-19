package peaksoft.repository;

import peaksoft.model.Course;

import java.util.List;

public interface CourseRepository {

    void saveCourse(Course course, Long id);

    Course getCourseById(Long id);

    List<Course> getAllCourses();

    void updateCourse(Course course,Long id);

    void deleteCourseById(Long id);

}
