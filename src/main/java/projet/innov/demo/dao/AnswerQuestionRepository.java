package projet.innov.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.innov.demo.entities.AnswerQuestion;

public interface AnswerQuestionRepository extends JpaRepository<AnswerQuestion,Long> {
}
