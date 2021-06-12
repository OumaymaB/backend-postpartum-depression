package projet.innov.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import projet.innov.demo.dao.PublicationRepository;
import projet.innov.demo.entities.Publication;
import projet.innov.demo.entities.User;

@Service
@AllArgsConstructor
public class PublicationService {
    private final PublicationRepository publicationRepository;

    public Publication createPublication(String hashTag, String description, User user) {
        Publication publication = Publication
                                    .builder()
                                    .hashtag(hashTag)
                                    .description(description)
                                    .user(user)
                                    .build();
        return publicationRepository.save(publication);
    }
}
