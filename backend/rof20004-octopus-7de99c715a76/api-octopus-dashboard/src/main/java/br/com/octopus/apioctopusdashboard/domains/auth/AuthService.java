package br.com.octopus.apioctopusdashboard.domains.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.octopus.apioctopusdashboard.domains.token.TokenDTO;
import br.com.octopus.apioctopusdashboard.domains.token.TokenService;
import br.com.octopus.apioctopusdashboard.domains.user.User;
import br.com.octopus.apioctopusdashboard.domains.user.UserService;
import br.com.octopus.apioctopusdashboard.exceptions.AuthException;

@Service
public class AuthService {

	@Autowired
	private UserService userService;

	@Autowired
	private TokenService tokenService;

	public TokenDTO authenticate(AuthDTO dto) throws AuthException {
		validate(dto);

		User user = userService.findByUsername(dto.getUsername());
		if (user == null) {
			throw new AuthException("Usuário não encontrado");
		}

		boolean ok = isPasswordMatches(dto.getPassword(), user.getPassword());
		if (!ok) {
			throw new AuthException("Usuário e/ou senha inválido(s)");
		}

		return tokenService.generateJWT(user.getUsername());
	}

	private boolean isPasswordMatches(String password, String encodedPassword) throws AuthException {
		BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), encodedPassword);
		return result.verified;
	}

	private void validate(AuthDTO dto) throws AuthException {
		if (dto == null) {
			throw new AuthException("É obrigatório informar usuário e senha");
		}

		validateUsername(dto.getUsername());
		validatePassword(dto.getPassword());
	}

	private void validateUsername(String username) throws AuthException {
		if (username == null || username.isEmpty()) {
			throw new AuthException("É obrigatório informar o usuário");
		}
	}

	private void validatePassword(String password) throws AuthException {
		if (password == null || password.isEmpty()) {
			throw new AuthException("É obrigatório informar a senha");
		}
	}

}
