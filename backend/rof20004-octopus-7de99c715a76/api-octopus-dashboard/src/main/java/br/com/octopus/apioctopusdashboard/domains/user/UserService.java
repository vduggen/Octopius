package br.com.octopus.apioctopusdashboard.domains.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.octopus.apioctopusdashboard.exceptions.AuthException;
import br.com.octopus.apioctopusdashboard.exceptions.UserException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserDTO create(UserDTO dto) throws UserException {
		validateUser(dto);
		
		String encodedPassword = BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, dto.getPassword().toCharArray());

		User user = User.builder().username(dto.getUsername()).password(encodedPassword).build();
		userRepository.save(user);

		dto.setId(user.getId());
		dto.setPassword(null);

		return dto;
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	private void validateUser(UserDTO dto) throws UserException {
		if (dto == null) {
			throw new UserException("É obrigatório informar nome, usuário e senha");
		}
		
		validateUserName(dto.getName());
		validateUserUsername(dto.getUsername());
		validateUserPassword(dto.getPassword());
	}
	
	private void validateUserName(String name) throws UserException {
		if (name == null || name.isEmpty()) {
			throw new AuthException("É obrigatório informar o nome");
		}
	}
	
	private void validateUserUsername(String username) throws UserException {
		if (username == null || username.isEmpty()) {
			throw new AuthException("É obrigatório informar o usuário");
		}
	}

	private void validateUserPassword(String password) throws UserException {
		if (password == null || password.isEmpty()) {
			throw new AuthException("É obrigatório informar a senha");
		}
	}

}
