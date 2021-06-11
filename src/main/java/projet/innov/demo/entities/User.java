package projet.innov.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String mail;
    private String password;
    private Date dateBirth;
    private String photo;
    private String bio;
    @OneToMany(mappedBy = "user")
    private Collection<Comment> comments;
    @OneToMany(mappedBy = "user")
    private Collection<Publication> publications;
    @OneToMany(mappedBy = "user")
    private Collection<TaskCalendar> tasksCalendar;
    @OneToOne(mappedBy = "user")
    private TestDepression testDepression;
    @ManyToMany(mappedBy = "following",fetch = FetchType.EAGER)
    private Collection<User> followers = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<User> following = new ArrayList<>();



}