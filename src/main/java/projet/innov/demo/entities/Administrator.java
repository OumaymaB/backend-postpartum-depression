package projet.innov.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;
@Entity
@Data @NoArgsConstructor
public class Administrator extends User implements Serializable {

}
