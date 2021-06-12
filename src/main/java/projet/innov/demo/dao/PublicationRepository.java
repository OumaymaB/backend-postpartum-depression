package projet.innov.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.innov.demo.entities.Publication;
import projet.innov.demo.entities.User;

import java.util.Collection;
import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
    List<Publication> findByUser_Id(Long id);

    List<Publication> findByUserIn(Collection<User> users);

}
