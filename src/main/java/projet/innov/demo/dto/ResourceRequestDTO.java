package projet.innov.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.innov.demo.enums.ResourceEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceRequestDTO {
    private ResourceEnum type;
    private String link;
}
