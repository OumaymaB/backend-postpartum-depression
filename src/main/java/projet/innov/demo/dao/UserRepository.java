package projet.innov.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import projet.innov.demo.entities.User;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUserNameContains(String userName);
}
