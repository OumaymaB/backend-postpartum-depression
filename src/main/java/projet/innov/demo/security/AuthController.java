package projet.innov.demo.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import projet.innov.demo.dto.UserDTO;
import projet.innov.demo.entities.Publication;
import projet.innov.demo.entities.User;
import projet.innov.demo.service.UserService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class AuthController {
    private final TokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @PostMapping("/login")
    public JwtResponse signIn(@RequestBody SignInRequest signInRequest) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.getEmail(),
                        signInRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return new JwtResponse(token, Constants.ACCESS_TOKEN_VALIDITY_SECONDS, ((User) authentication.getPrincipal()).getId());

    }

    @PostMapping("/register")
    public JwtResponse singUp(@RequestBody UserDTO userDTO) {
        userService.createAccount(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getUserName(), userDTO.getMail(), userDTO.getPassword(), userDTO.getDateBirth(), userDTO.getPhoto(), userDTO.getBio());
        return signIn(new SignInRequest(userDTO.getMail(), userDTO.getPassword()));
    }

    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAccount(@PathVariable Long id) {
        userService.deleteAccount(id);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        userService.updateAccount(id, userDTO.getFirstName(), userDTO.getLastName(), userDTO.getUserName(), userDTO.getDateBirth(), userDTO.getPhoto(), userDTO.getBio());
    }

    @PutMapping("/user/{id}/password")
    public void updatePassword(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        userService.updatePassword(id, userDTO.getPassword());
    }

	@GetMapping(value = "/photoUser/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] image(@PathVariable (name ="id")Long id)throws Exception{
		User user=userService.getById(id);
		String photoName=user.getPhoto();
		File file=new File(System.getProperty("user.home")+"/upload/user/"+photoName);
		Path path= Paths.get(file.toURI());
		return Files.readAllBytes(path);
	}

	@PostMapping(path = "/uploadPhoto/user")
	public Map<String,Object> uploadPhoto(@RequestParam("image") MultipartFile file) throws Exception{
		String name=file.getOriginalFilename();
		int i= name.lastIndexOf(".");
		if (i<0) throw new Exception();
		name= Calendar.getInstance().getTimeInMillis()+name.substring(i);
		Files.write(Paths.get(System.getProperty("user.home")+"/upload/user/"+name),file.getBytes());
		Map<String,Object> resp=new HashMap<>();
		resp.put("path",name);
		return resp;
	}

    @GetMapping(path = "/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping(path = "/users/{name}")
    public List<User> getUsers(@PathVariable String name) {
        return userService.getUsers(name);
    }


}
