package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.model.Group;
import peaksoft.service.CourseService;
import peaksoft.service.GroupService;

@Controller
@RequestMapping
public class GroupController {

    private final GroupService groupService;
    private final CourseService courseService;
     @Autowired
    public GroupController(GroupService groupService, CourseService courseService) {
        this.groupService = groupService;
        this.courseService = courseService;
    }

    @GetMapping("/allGroup/{id}")
    public  String getAllGroups(Model model,@PathVariable Long id) {
         model.addAttribute("groups",groupService.getAllGroups(id));
         model.addAttribute("courseId",id);
         return "/group/allGroup";
    }
//    @GetMapping()
//    public String getGroupById(Model model,@PathVariable("groupId") Long id) {
//         model.addAttribute("group",groupService.getGroupById(id));
//         return "/group/oneGroup";
//    }
//
    @PostMapping("/deleteGroup/{id}")
    public String deleteCompanyById(@PathVariable Long id) {
        groupService.deleteGroupById(id);
        return "redirect:/allGroup/{id}";
    }

    @GetMapping("/newGroup/{id}")
    public String newCourse(Model model,@PathVariable Long id) {
        model.addAttribute("group",new Group());
        model.addAttribute("courseId",id);
        return "/group/saveGroup";
    }
    @PostMapping("/saveGroup/{id}")
    public String saveCourse(@ModelAttribute("group") Group group,@PathVariable Long id) {
        groupService.saveGroup(group);
        return "redirect:/allGroup/{id}";
    }
    @GetMapping("/findGroup/{id}")
    public String edit(@PathVariable Long id,Model model) {
        model.addAttribute("group",groupService.getGroupById(id));
        model.addAttribute("courseId",id);
        return "/group/updateGroup";
    }

    @PostMapping("/updateGroup/{id}")
    public String  updateCourse(@ModelAttribute("group")Group group,
                                @PathVariable Long id) {
        groupService.updateGroup(group,id);

        return "redirect:/allGroup/{id}";
    }

}
