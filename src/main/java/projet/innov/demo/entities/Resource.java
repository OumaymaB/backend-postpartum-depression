package projet.innov.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.innov.demo.enums.ResourceEnum;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Resource implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String link;
    private ResourceEnum type;
    @ManyToOne
    @JsonIgnore
    private Publication publication;
}
