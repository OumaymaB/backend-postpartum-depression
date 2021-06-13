package projet.innov.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import projet.innov.demo.entities.Resource;
import projet.innov.demo.enums.ResourceEnum;
import projet.innov.demo.service.ResourceService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@AllArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    @GetMapping(value = "/photoResource/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable(name ="id")Long id)throws Exception{
        Resource resource=resourceService.getById(id);
        if (resource.getType()== ResourceEnum.IMAGE){
            String photoName=resource.getLink();
            File file=new File(System.getProperty("user.home")+"/upload/resource/"+photoName);
            Path path= Paths.get(file.toURI());
            return Files.readAllBytes(path);
        }
        return null;
    }

    @PostMapping(path = "/uploadPhoto/resource")
    public Map<String,Object> uploadPhoto(MultipartFile file) throws Exception{
        String name=file.getOriginalFilename();
        int i= name.lastIndexOf(".");
        if (i<0) throw new Exception();
        name= Calendar.getInstance().getTimeInMillis()+name.substring(i);
        Files.write(Paths.get(System.getProperty("user.home")+"/upload/resource/"+name),file.getBytes());
        Map<String,Object> resp=new HashMap<>();
        resp.put("path",name);
        return resp;
    }
}
