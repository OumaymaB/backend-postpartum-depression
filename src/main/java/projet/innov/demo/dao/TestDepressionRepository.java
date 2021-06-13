package projet.innov.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.innov.demo.entities.TestDepression;
import projet.innov.demo.entities.User;

public interface TestDepressionRepository extends JpaRepository<TestDepression,Long> {
    TestDepression findByUser(User user);
}
