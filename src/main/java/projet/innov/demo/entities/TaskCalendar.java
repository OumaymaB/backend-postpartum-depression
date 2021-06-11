package projet.innov.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.DateTimeException;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class TaskCalendar implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String task;
    private DateTimeException date;
    private boolean done;
    @ManyToOne
    private User user;
}
