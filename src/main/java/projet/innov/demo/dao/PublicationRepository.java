package projet.innov.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import projet.innov.demo.entities.Publication;

import java.util.List;

@RepositoryRestResource
public interface PublicationRepository extends JpaRepository<Publication,Long> {
    List<Publication> findByUser_Id(Long id);
}
