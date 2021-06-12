package projet.innov.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet.innov.demo.dto.PublicationRequestDTO;
import projet.innov.demo.entities.Publication;
import projet.innov.demo.entities.User;
import projet.innov.demo.service.PublicationService;

@RestController
@AllArgsConstructor
@RequestMapping("/publication")
public class PublicationController {
    private final PublicationService publicationService;

    @PostMapping(value = "")
    public Publication createPublication(@RequestBody PublicationRequestDTO request){
        User user=new User();
        user.setId(1);
        return publicationService.createPublication(request.getHashTag(),request.getDescription(),user);
    }
}
