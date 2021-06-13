package projet.innov.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import projet.innov.demo.dao.RoleRepository;
import projet.innov.demo.entities.Role;
import projet.innov.demo.enums.RoleEnum;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getRoleByName(RoleEnum role){
        return roleRepository.findByRole(role);
    }
}
