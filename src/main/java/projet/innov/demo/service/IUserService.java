package projet.innov.demo.service;

import projet.innov.demo.entities.Comment;
import projet.innov.demo.entities.Publication;
import projet.innov.demo.entities.User;

import java.util.List;

public interface IUserService {
    //gestion des utilisateurs

    public void createCompte(User user);
    public void deleteCompte(long id);
    public List<User> searchUsers(String userName);
    public void editProfile(User user);

    //gestion des publications
    public void addPublication(Publication publication);
    public void deletePublication(long id);
    public void addComment(Comment comment);
    public void deleteComment(long id);

    //resautage
    public void followUser();


}
