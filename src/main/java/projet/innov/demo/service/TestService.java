package projet.innov.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import projet.innov.demo.dao.AnswerQuestionRepository;
import projet.innov.demo.dao.TestDepressionRepository;
import projet.innov.demo.entities.AnswerQuestion;
import projet.innov.demo.entities.TestDepression;
import projet.innov.demo.entities.User;

@Service
@AllArgsConstructor
public class TestService {
    private final TestDepressionRepository testDepressionRepository;
    private final AnswerQuestionRepository answerQuestionRepository;

    public TestDepression createTest(User user) {
        TestDepression testDepression = new TestDepression();
        testDepression.setTotal(0);
        testDepression.setUser(user);
        return testDepressionRepository.save(testDepression);
    }

    public AnswerQuestion createAnswer(Long idTest, int numQuestion, String answer, int scale) {
        TestDepression testDepression = getById(idTest);
        AnswerQuestion answerQuestion = new AnswerQuestion();
        answerQuestion.setAnswerQuestion(answer);
        answerQuestion.setNumQuestion(numQuestion);
        answerQuestion.setScale(scale);
        answerQuestion.setTestDepression(testDepression);
        testDepression.addToTotal(scale);
        testDepressionRepository.save(testDepression);
        return answerQuestionRepository.save(answerQuestion);
    }

    public TestDepression getById(Long id) {
        return testDepressionRepository.findById(id).get();
    }
}
