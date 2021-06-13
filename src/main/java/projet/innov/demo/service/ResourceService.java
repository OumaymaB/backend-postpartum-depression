package projet.innov.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import projet.innov.demo.dao.PublicationRepository;
import projet.innov.demo.dao.ResourceRepository;
import projet.innov.demo.dto.ResourceRequestDTO;
import projet.innov.demo.entities.Publication;
import projet.innov.demo.entities.Resource;
import projet.innov.demo.entities.User;
import projet.innov.demo.enums.ResourceEnum;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ResourceService {
    private final ResourceRepository resourceRepository;

    public Resource createResource(ResourceEnum type, String link, Publication publication) {
        Resource resource = new Resource();
        resource.setLink(link);
        resource.setType(type);
        resource.setPublication(publication);
        return resourceRepository.save(resource);
    }
    public List<Resource> createListResource(List<ResourceRequestDTO> requests, Publication publication){
        List<Resource> resources=new ArrayList<>();
        for (ResourceRequestDTO request : requests) {
            Resource resource=createResource(request.getType(), request.getLink(), publication);
            resources.add(resource);
        }
        return resources;
    }

    public Resource getById(Long id){
        return resourceRepository.findById(id).get();
    }
}
