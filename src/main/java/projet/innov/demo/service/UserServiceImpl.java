package projet.innov.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.innov.demo.dao.CommentRepository;
import projet.innov.demo.dao.PublicationRepository;
import projet.innov.demo.dao.ResourceRepository;
import projet.innov.demo.dao.UserRepository;
import projet.innov.demo.entities.Comment;
import projet.innov.demo.entities.Publication;
import projet.innov.demo.entities.Resource;
import projet.innov.demo.entities.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public boolean createCompte(User user) {

      if(!userRepository.findByMail(user.getMail())){
          userRepository.save(user);
          return true;
      }
      return false;

    }

    @Override
    public void deleteCompte(long id) {
     userRepository.deleteById(id);
    }

    @Override
    public List<User> searchUsers(String userName) {
        return userRepository.findByUserNameContains(userName);
    }

    @Override
    public void editProfile(User user) {
        userRepository.save(user);
    }

    @Override
    public void addResource(Resource resource) {
        resourceRepository.save(resource);
    }

    @Override
    public void addPublication(Publication publication) {
        //ask about it
      publicationRepository.save(publication);
    }

    @Override
    public void deletePublication(long id) {
     publicationRepository.deleteById(id);
    }

    @Override
    public void addComment(Comment comment) {
      commentRepository.save(comment);
    }

    @Override
    public void deleteComment(long id) {
      commentRepository.deleteById(id);
    }

    @Override
    public void followUser() {
      //ask about this
    }
}
