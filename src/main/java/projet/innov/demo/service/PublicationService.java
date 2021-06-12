package projet.innov.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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
    private final CommentService commentService;

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

    public Publication updatePublicationWithComments(List<CommentRequestDTO> commentsDTO,Publication publication, User user){
        List<Comment> comments = commentService.createListComment(commentsDTO,publication,user);
        publication.setComments(comments);
        publicationRepository.save(publication);//*
        return publication;
    }

    public void deletePublication(long id){
        publicationRepository.deleteById(id);
    }

    public List<Comment> getComments(long id){
        return null;
    }


}
