package projet.innov.demo.service;

import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.innov.demo.dao.PublicationRepository;
import projet.innov.demo.dto.CommentRequestDTO;
import projet.innov.demo.dto.ResourceRequestDTO;
import projet.innov.demo.entities.Comment;
import projet.innov.demo.entities.Publication;
import projet.innov.demo.entities.Resource;
import projet.innov.demo.entities.User;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PublicationService {
    private final PublicationRepository publicationRepository;
    private final ResourceService resourceService;
    private final UserService userService;

    public Publication createPublication(Date date, String hashtag, String description, List<ResourceRequestDTO> resourcesDTO, User user) {

        Publication publication = Publication
                .builder()
                .date(date)
                .hashtag(hashtag)
                .description(description)
                .user(user)
                .build();

        publication = publicationRepository.save(publication);
        List<Resource> resources = resourceService.createListResource(resourcesDTO, publication);
        publication.setResources(resources);
        return publication;
    }

    public Publication getById(Long id) {
        return publicationRepository.findById(id).get();
    }

    public void deletePublication(long id) {
        publicationRepository.deleteById(id);
    }

    public List<Publication> getAllSortByDate(){
        return publicationRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    //@Transactional
    //public List<Publication> getPublications(Long userId) {
    //    User user=userService.getById(userId);
    //    return publicationRepository.findByUserIn(user.getFollowing());
    //}
}
