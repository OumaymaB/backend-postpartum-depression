package projet.innov.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import projet.innov.demo.dao.PublicationRepository;
import projet.innov.demo.dto.ResourceRequestDTO;
import projet.innov.demo.entities.Publication;
import projet.innov.demo.entities.Resource;
import projet.innov.demo.entities.User;

import java.util.List;

@Service
@AllArgsConstructor
public class PublicationService {
    private final PublicationRepository publicationRepository;
    private final ResourceService resourceService;

    public Publication createPublication(String hashtag, String description, List<ResourceRequestDTO> resourcesDTO, User user) {

        Publication publication = Publication
                .builder()
                .hashtag(hashtag)
                .description(description)
                .user(user)
                .build();

        publication = publicationRepository.save(publication);
        List<Resource> resources=resourceService.createListResource(resourcesDTO, publication);
        publication.setResources(resources);
        return publication;
    }
}
