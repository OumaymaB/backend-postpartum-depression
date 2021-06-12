package projet.innov.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.innov.demo.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUserNameContains(String userName);
    User findByMail(String mail);
}
