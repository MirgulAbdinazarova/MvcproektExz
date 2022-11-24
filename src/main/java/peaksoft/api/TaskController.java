package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import peaksoft.model.Course;
import peaksoft.model.Lesson;
import peaksoft.model.Task;
import peaksoft.service.TaskService;

@Controller
public class TaskController {

    private final TaskService taskService;
     @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/allTask/{id}")
    public String getAllTasks(Model model, @PathVariable Long id) {
         model.addAttribute("tasks",taskService.getAllTasks(id));
         model.addAttribute("lessonId",id);
         return "/task/allTask";
    }
    @GetMapping("/newTask/{id}")
    public String newInstructor(Model model,@PathVariable Long id) {
        model.addAttribute("task",new Task());
        model.addAttribute("lessonId",id);
        return "/task/saveTask";
    }
    @PostMapping("/saveTask/{id}")
    public String saveInstructor(@ModelAttribute("task") Task task,
                                 @PathVariable Long id) {
        taskService.saveTask(task,id);
        return "redirect:/allTask/{id}";
    }
    @GetMapping("/findTask/{id}")
    public String edit(@PathVariable("id")Long id,Model model) {
        model.addAttribute("task",taskService.getTaskById(id));
        return "/task/updateTask";
    }

    @PostMapping("/updateTask/{id}")
    public String  updateCourse(@ModelAttribute("task") Task task
            ,@PathVariable Long id) {
        taskService.updateTask(task,id);
        return "redirect:/allTask/{id}";
    }
    @PostMapping("/deleteTask/{id}")
    public String deleteCourse(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/allTask/{id}";
    }

}
