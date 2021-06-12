package projet.innov.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.innov.demo.entities.TaskCalendar;

public interface TaskCalendarRepository extends JpaRepository<TaskCalendar,Long> {
}
