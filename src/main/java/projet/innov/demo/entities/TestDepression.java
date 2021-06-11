package projet.innov.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class TestDepression implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int total;
    @OneToMany(mappedBy = "testDepression")
    private Collection<AnswerQuestion> answerQuestions;
    @OneToOne
    private User user;

}
