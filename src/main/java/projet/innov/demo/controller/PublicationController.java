package projet.innov.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import projet.innov.demo.dto.CommentRequestDTO;
import projet.innov.demo.dto.PublicationRequestDTO;
import projet.innov.demo.entities.Comment;
import projet.innov.demo.entities.Publication;
import projet.innov.demo.entities.User;
import projet.innov.demo.service.CommentService;
import projet.innov.demo.service.PublicationService;

import java.util.Collection;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/publication")
public class PublicationController {
    private final PublicationService publicationService;
    private final CommentService commentService;

    @PostMapping()
    public Publication createPublication(@RequestBody PublicationRequestDTO request) {
        User user = new User();
        user.setId(1);
        return publicationService.createPublication(request.getHashtag(), request.getDescription(), request.getResources(), user);
    }

    @PostMapping(value = "{id}/comments")
    public Comment createPubComments(@PathVariable Long id, @RequestBody CommentRequestDTO request) {
        User user = new User();
        user.setId(2);
        Publication publication = publicationService.getById(id);
        return commentService.createComment(request.getContent(), request.getDate(), publication, user);
    }

    @GetMapping(value = "{id}/comments")
    public Collection<Comment> getAllComments(@PathVariable Long id) {
        return publicationService.getById(id).getComments();
    }

    @GetMapping
    public List<Publication> getPublications() {
        return publicationService.getPublications();
    }
}
