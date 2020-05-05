package br.com.octopus.apioctopusdashboard.domains.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.octopus.apioctopusdashboard.exceptions.UserException;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST })
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/v1/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public UserDTO create(@RequestBody UserDTO dto) throws UserException {
		return userService.create(dto);
	}

}
