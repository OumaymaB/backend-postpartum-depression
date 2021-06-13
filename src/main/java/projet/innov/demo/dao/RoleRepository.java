package projet.innov.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.innov.demo.entities.Role;
import projet.innov.demo.enums.RoleEnum;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(String role);
}
