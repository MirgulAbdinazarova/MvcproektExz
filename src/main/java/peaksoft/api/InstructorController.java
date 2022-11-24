package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import peaksoft.model.Course;
import peaksoft.model.Instructor;
import peaksoft.service.InstructorService;

@Controller
public class InstructorController {

    private final InstructorService instructorService;
     @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping("/allIns/{id}")
    public String getAllInstructors(Model model,@PathVariable Long id) {
         model.addAttribute("instructors",instructorService.getAllInstructors(id));
         model.addAttribute("courseId",id);
         return "/instructor/allIns";
    }

    @PostMapping("/remove/{id}")
    public String deleteInstructor(@PathVariable Long id) {
         instructorService.deleteInstructorById(id);
         return "redirect:/allIns/{id}";
    }
    @GetMapping("/newIns/{id}")
    public String newInstructor(Model model,@PathVariable Long id) {
         model.addAttribute("instructor",new Instructor());
         model.addAttribute("courseId",id);
         return "/instructor/saveIns";
    }
    @PostMapping("/saveIns/{id}")
    public String saveInstructor(@ModelAttribute("instructor") Instructor instructor,
                                 @PathVariable Long id) {
         instructorService.saveInstructor(instructor,id);
         return "redirect:/allIns/{id}";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id")Long id,Model model) {
        model.addAttribute("instructor",instructorService.getInstructorById(id));
        return "/instructor/updateIns";
    }

    @PostMapping("/updateIns/{id}")
    public String  updateInstructor(@ModelAttribute("instructor") Instructor instructor
            ,@PathVariable Long id) {
        instructorService.updateInstructor(instructor,id);
        return "redirect:/allIns/{id}";
    }

}
