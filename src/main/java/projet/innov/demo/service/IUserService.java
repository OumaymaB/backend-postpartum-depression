package projet.innov.demo.service;

import projet.innov.demo.entities.Publication;
import projet.innov.demo.entities.User;

import java.util.List;

public interface IUserService {
    //gestion des utilisateurs

    public void createCompte();
    public void deleteCompte();
    public List<User> searchUsers();
    public void editProfile();

    //gestion des publications
    public void addPublication();
    public void deletePublication();
    public List<Publication> getPublications();
    public void addComment();
    public void deleteComment();

    //resautage
    public void followUser();


}
