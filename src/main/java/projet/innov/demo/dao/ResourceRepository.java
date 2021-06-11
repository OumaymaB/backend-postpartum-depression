package projet.innov.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import projet.innov.demo.entities.Resource;
@RepositoryRestResource
public interface ResourceRepository extends JpaRepository<Resource,Long> {
}
