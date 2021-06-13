package projet.innov.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import projet.innov.demo.dto.TaskCalendarDTO;
import projet.innov.demo.dto.TaskCalendarGetDTO;
import projet.innov.demo.entities.TaskCalendar;
import projet.innov.demo.entities.User;
import projet.innov.demo.service.TaskService;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("task")
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public TaskCalendar createTask(@RequestBody TaskCalendarDTO taskRequest,@AuthenticationPrincipal User user) {
        return taskService.createTask(taskRequest.getTask(), taskRequest.getDate(),user);
    }

    @GetMapping
    public List<TaskCalendar> getByDate(@RequestBody TaskCalendarGetDTO request,@AuthenticationPrincipal User user) {
        return taskService.getByDate(request.getDate(),user);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
