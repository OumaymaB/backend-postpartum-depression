package projet.innov.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.innov.demo.entities.Resource;

public interface ResourceRepository extends JpaRepository<Resource,Long> {
}
