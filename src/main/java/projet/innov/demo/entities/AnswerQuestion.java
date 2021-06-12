package projet.innov.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AnswerQuestion implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int numQuestion;
    private String answerQuestion;
    private int scale;
    @ManyToOne
    @JsonIgnore
    private TestDepression testDepression;

}
