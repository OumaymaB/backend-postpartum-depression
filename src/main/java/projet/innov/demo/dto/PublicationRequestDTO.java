package projet.innov.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationRequestDTO {
    private Date date;
    private String hashtag;
    private String description;
    private List<ResourceRequestDTO> resources;
}
