package projet.innov.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projet.innov.demo.dao.UserRepository;
import projet.innov.demo.entities.Role;
import projet.innov.demo.entities.User;
import projet.innov.demo.enums.RoleEnum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final TestService testService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public User createAccount(String firstName, String lastName, String userName, String mail, String password, Date dateBirth, String photo, String bio) {
        if (userRepository.findByMail(mail) == null) {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUserName(userName);
            user.setMail(mail);
            user.setPassword(passwordEncoder.encode(password));
            user.setDateBirth(dateBirth);
            user.setPhoto(photo);
            user.setBio(bio);
            user.setRoles(new ArrayList<>());
            user.addRole(roleService.getRoleByName(RoleEnum.USER.getRole()));
            user = userRepository.save(user);
            testService.createTest(user);
            return user;
        }
        return null;
    }

    public User updateAccount(Long id, String firstName, String lastName, String userName, Date dateBirth, String photo, String bio) {
        User user = userRepository.findById(id).get();
        if (user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUserName(userName);
            user.setDateBirth(dateBirth);
            user.setPhoto(photo);
            user.setBio(bio);
            return userRepository.save(user);
        }
        return null;
    }

    public User updatePassword(Long id, String password) {
        User user = userRepository.findById(id).get();
        if (user != null) {
            user.setPassword(passwordEncoder.encode(password));
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteAccount(long id) {
        userRepository.deleteById(id);
    }

    public User getById(Long id){
        return userRepository.findById(id).get();
    }

    public List<User> getUsers(String username) {
        return userRepository.findByUserNameContains(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByMail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return user;
    }
}
