package projet.innov.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String userName;
    private String mail;
    private String password;
    private Date dateBirth;
    private String photo;
    private String bio;
}
