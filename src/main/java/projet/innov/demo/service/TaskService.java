package projet.innov.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import projet.innov.demo.dao.TaskCalendarRepository;
import projet.innov.demo.entities.TaskCalendar;
import projet.innov.demo.entities.User;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskCalendarRepository taskRepository;

    public TaskCalendar createTask(String task, Date date, User user) {
        TaskCalendar taskCalendar = new TaskCalendar();
        taskCalendar.setTask(task);
        taskCalendar.setDate(date);
        taskCalendar.setUser(user);
        return taskRepository.save(taskCalendar);
    }

    public List<TaskCalendar> getByDate(Date date,User user) {
        return taskRepository.findByUserAndDate(user, date);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
