package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Lesson;
import peaksoft.repository.LessonRepository;
import peaksoft.service.LessonService;

import java.util.List;
@Service
public class LessonServiceImpl  implements LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void saveLesson(Lesson lesson, Long id) {
        lessonRepository.saveLesson(lesson,id);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonRepository.getLessonById(id);
    }

    @Override
    public List<Lesson> getAllLessons(Long id) {
        return lessonRepository.getAllLessons(id);
    }

    @Override
    public void updateLesson(Lesson lesson, Long id) {
     lessonRepository.updateLesson(lesson,id);
    }

    @Override
    public void deleteLessonById(Long id) {
     lessonRepository.deleteLessonById(id);
    }
}
