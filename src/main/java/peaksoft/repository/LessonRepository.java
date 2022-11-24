package peaksoft.repository;

import peaksoft.model.Course;
import peaksoft.model.Lesson;

import java.util.List;

public interface LessonRepository {

    void saveLesson(Lesson lesson, Long id);

    Lesson getLessonById(Long id);

    List<Lesson> getAllLessons(Long id);

    void updateLesson(Lesson lesson,Long id);

    void deleteLessonById(Long id);
}
