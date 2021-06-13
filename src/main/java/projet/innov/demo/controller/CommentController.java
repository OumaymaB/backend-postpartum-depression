package projet.innov.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import projet.innov.demo.service.CommentService;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
