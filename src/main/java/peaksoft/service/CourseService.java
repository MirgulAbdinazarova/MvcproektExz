package peaksoft.service;

import peaksoft.model.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(Course course, Long id);

    Course getCourseById(Long id);

    List<Course> getAllCourses();

    void updateCourse(Course course,Long id);

    void deleteCourseById(Long id);

}
