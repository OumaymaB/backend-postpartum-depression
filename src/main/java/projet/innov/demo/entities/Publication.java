package projet.innov.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Publication implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String hashtag;
    private String description;
    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL)
    private Collection<Resource> resources;
    @OneToMany(mappedBy = "publication",orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Comment> comments;
    @ManyToOne
    @JsonIgnore
    private User user;
}
