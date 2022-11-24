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
import peaksoft.model.Student;
import peaksoft.service.StudentService;

@Controller
public class StudentController {

    private final StudentService studentService;
     @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/allStudents/{id}")
    public String getAllStudents(Model model, @PathVariable Long id) {
         model.addAttribute("students",studentService.getAllStudents(id));
         model.addAttribute("groupId",id);
         return "/student/allStudents";
    }

    @GetMapping("/newStudent/{id}")
    public String newInstructor(Model model,@PathVariable Long id) {
        model.addAttribute("student",new Student());
        model.addAttribute("groupId",id);
        return "/student/saveStudent";
    }
    @PostMapping("/saveStudent/{id}")
    public String saveInstructor(@ModelAttribute("student") Student student,
                                 @PathVariable Long id) {
        studentService.saveStudent(student,id);
        return "redirect:/allStudents/{id}";
    }

    @GetMapping("/findStudent/{id}")
    public String edit(@PathVariable("id")Long id,Model model) {
        model.addAttribute("student",studentService.getStudentById(id));
        return "/student/updateStudent";
    }

    @PostMapping("/updateStudent/{id}")
    public String  updateLesson(@ModelAttribute("student") Student student
            ,@PathVariable Long id) {
        studentService.updateStudent(student,id);
        return "redirect:/allStudents/{id}";
    }

    @PostMapping("/deleteStudent/{id}")
    public String deleteCourse(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/allStudents/{id}";
    }
}
