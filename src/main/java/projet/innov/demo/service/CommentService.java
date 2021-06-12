package projet.innov.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import projet.innov.demo.dao.CommentRepository;
import projet.innov.demo.dto.CommentRequestDTO;
import projet.innov.demo.dto.ResourceRequestDTO;
import projet.innov.demo.entities.Comment;
import projet.innov.demo.entities.Publication;
import projet.innov.demo.entities.Resource;
import projet.innov.demo.entities.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment createComment(String content, Date date, Publication publication, User user) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setDate(date);
        comment.setPublication(publication);
        comment.setUser(user);
        return commentRepository.save(comment);
    }

    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }
}
