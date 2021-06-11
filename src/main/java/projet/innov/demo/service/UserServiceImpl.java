package projet.innov.demo.service;

import org.springframework.stereotype.Service;
import projet.innov.demo.entities.Publication;
import projet.innov.demo.entities.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

    @Override
    public void createCompte() {

    }

    @Override
    public void deleteCompte() {

    }

    @Override
    public List<User> searchUsers() {
        return null;
    }

    @Override
    public void editProfile() {

    }

    @Override
    public void addPublication() {

    }

    @Override
    public void deletePublication() {

    }

    @Override
    public List<Publication> getPublications() {
        return null;
    }

    @Override
    public void addComment() {

    }

    @Override
    public void deleteComment() {

    }
}
