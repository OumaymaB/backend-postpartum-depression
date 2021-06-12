package projet.innov.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Publication implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String hashtag;
    private String description;
    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL)
    private Collection<Resource> resources;
    @OneToMany(mappedBy = "publication",orphanRemoval = true,cascade = CascadeType.ALL)
    private Collection<Comment> comments;
    @ManyToOne
    private User user;
}
