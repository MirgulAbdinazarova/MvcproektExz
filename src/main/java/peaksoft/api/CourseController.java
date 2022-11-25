package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Course;
import peaksoft.model.Group;
import peaksoft.model.Instructor;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;
import peaksoft.service.GroupService;
import peaksoft.service.InstructorService;

@Controller
@RequestMapping("/course")
public class CourseController {
    private final InstructorService instructorService;
    private final CourseService courseService;
    private final GroupService groupService;
     @Autowired
    public CourseController(InstructorService instructorService, CourseService courseService, GroupService groupService) {
        this.instructorService = instructorService;
        this.courseService = courseService;
        this.groupService = groupService;
    }

    @GetMapping("/all/{id}")
    public String getAllCourses( Model model,@PathVariable Long id,
                                 @ModelAttribute("group") Group group) {
        model.addAttribute("courses",courseService.getAllCourses(id));
        model.addAttribute("groups", groupService.getAllGroups(id));
        model.addAttribute("companyId",id);
        return "/course/mainPage";
    }
    @GetMapping("/{courseId}")
    public String getCourseById(Model model, @PathVariable("courseId") Long id) {
        model.addAttribute("course",courseService.getCourseById(id));
        return "/course/innerPage";
    }

    @GetMapping("/new/{id}")
    public String newCourse(Model model,@PathVariable Long id) {
        model.addAttribute("course",new Course());
        model.addAttribute("companyId",id);
        return "/course/saveCourse";
    }

    @PostMapping("/saveCourse/{id}")
    public String saveCourse(@ModelAttribute("course") Course course, @PathVariable Long id) {
        courseService.saveCourse(course,id);
        return "redirect:/course/all/{id}";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourseById(id);
        return "redirect:/course/all/{id}";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id")Long id,Model model) {
        model.addAttribute("course",courseService.getCourseById(id));
        return "/course/updateCourse";
    }

    @PostMapping("/updateCourse/{id}")
    public String  updateCourse(@ModelAttribute("course")Course course
                                ,@PathVariable Long id) {
        courseService.updateCourse(course,id);
        return "redirect:/course/all/{id}";
    }
    @PostMapping("/{courseId}/assign")
    public String assignGroupToCourse(@PathVariable Long courseId, @ModelAttribute("group") Group group) {

         groupService.assignGroupToCourse(group.getId(), courseId);
         return "redirect:/course/all/{id}";
    }



}
