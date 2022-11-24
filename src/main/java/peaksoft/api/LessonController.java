package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import peaksoft.model.Instructor;
import peaksoft.model.Lesson;
import peaksoft.service.LessonService;
@Controller
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }
    @GetMapping("/allLess/{id}")
    public String getAllLessons(Model model, @PathVariable Long id) {
        model.addAttribute("lessons",lessonService.getAllLessons(id));    //course id
        model.addAttribute("courseId",id);
        return "/lesson/allLesson";
    }

    @GetMapping("/newLess/{id}")
    public String newInstructor(Model model,@PathVariable Long id) {
        model.addAttribute("lesson",new Lesson());
        model.addAttribute("courseId",id);
        return "/lesson/saveLesson";
    }
    @PostMapping("/saveLesson/{id}")
    public String saveInstructor(@ModelAttribute("lesson") Lesson lesson,
                                 @PathVariable Long id) {
        lessonService.saveLesson(lesson,id);
        return "redirect:/allLess/{id}";
    }

    @GetMapping("/updateLess/{id}")
    public String edit(@PathVariable("id")Long id,Model model) {
        model.addAttribute("lesson",lessonService.getLessonById(id));
        return "/lesson/updateLesson";
    }

    @PostMapping("/updateLesson/{id}")
    public String  updateLesson(@ModelAttribute("lesson") Lesson lesson
            ,@PathVariable Long id) {
        lessonService.updateLesson(lesson,id);
        return "redirect:/allLess/{id}";
    }

    @PostMapping("/deleteLesson/{id}")
    public String deleteCourse(@PathVariable Long id) {
        lessonService.deleteLessonById(id);
        return "redirect:/allLess/{id}";
    }

}
