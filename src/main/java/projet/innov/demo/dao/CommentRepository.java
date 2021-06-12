package projet.innov.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.innov.demo.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
