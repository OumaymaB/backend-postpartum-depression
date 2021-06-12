package projet.innov.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import projet.innov.demo.dto.AnswerQuestionDTO;
import projet.innov.demo.entities.AnswerQuestion;
import projet.innov.demo.service.TestService;

@RestController
@AllArgsConstructor
@RequestMapping("test")
public class TestController {
    private final TestService testService;

    @PostMapping("{id}")
    public AnswerQuestion createAnswer(@PathVariable Long id, @RequestBody AnswerQuestionDTO request){
        return testService.createAnswer(id,request.getNumQuestion(),request.getAnswerQuestion(),request.getScale());
    }
}
