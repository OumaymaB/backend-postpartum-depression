package projet.innov.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.innov.demo.entities.TaskCalendar;
import projet.innov.demo.entities.User;

import java.util.Date;
import java.util.List;

public interface TaskCalendarRepository extends JpaRepository<TaskCalendar, Long> {
    List<TaskCalendar> findByUserAndDate(User user, Date date);
}
