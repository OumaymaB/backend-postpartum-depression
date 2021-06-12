package projet.innov.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.innov.demo.entities.TestDepression;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerQuestionDTO {
    private int numQuestion;
    private String answerQuestion;
    private int scale;
}
