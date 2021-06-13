package projet.innov.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import projet.innov.demo.dto.AnswerQuestionDTO;
import projet.innov.demo.entities.AnswerQuestion;
import projet.innov.demo.entities.User;
import projet.innov.demo.service.TestService;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("test")
public class TestController {
    private final TestService testService;

    @PostMapping()
    public AnswerQuestion createAnswer(@AuthenticationPrincipal User user, @RequestBody AnswerQuestionDTO request){
        return testService.createAnswer(user,request.getNumQuestion(),request.getAnswerQuestion(),request.getScale());
    }
}
