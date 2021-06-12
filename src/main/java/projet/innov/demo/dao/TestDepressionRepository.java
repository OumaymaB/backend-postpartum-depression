package projet.innov.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.innov.demo.entities.TestDepression;

public interface TestDepressionRepository extends JpaRepository<TestDepression,Long> {
}
