package projet.innov.demo.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import projet.innov.demo.dto.UserDTO;
import projet.innov.demo.entities.User;
import projet.innov.demo.service.UserService;


@CrossOrigin
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
			return new JwtResponse(token,Constants.ACCESS_TOKEN_VALIDITY_SECONDS,((User)authentication.getPrincipal()).getId());

	    }
	    public JwtResponse singUp(@RequestBody UserDTO userDTO){
	    	userService.createAccount(userDTO.getFirstName(),userDTO.getLastName(),userDTO.getUserName(),userDTO.getMail(),userDTO.getPassword(),userDTO.getDateBirth(),userDTO.getPhoto(),userDTO.getBio());
	    	return null;
		}
	    
}
