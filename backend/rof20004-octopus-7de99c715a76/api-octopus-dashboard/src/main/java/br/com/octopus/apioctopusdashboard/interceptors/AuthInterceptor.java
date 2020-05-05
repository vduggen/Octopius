package br.com.octopus.apioctopusdashboard.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.octopus.apioctopusdashboard.domains.token.TokenService;
import br.com.octopus.apioctopusdashboard.exceptions.AuthException;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String BEARER_TOKEN = "Bearer ";
	
	@Autowired
	private TokenService tokenService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws AuthException, Exception {
		
		String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);
		if (StringUtils.isEmpty(authorizationHeader) || !authorizationHeader.startsWith(BEARER_TOKEN)) {
			throw new AuthException("Requisição recebida sem o cabeçalho " + AUTHORIZATION_HEADER);
		}

		String token = authorizationHeader.replace(BEARER_TOKEN, "");
		if (token.isEmpty()) {
			throw new AuthException("Requisição recebida sem o token " + BEARER_TOKEN + " no cabeçalho " + AUTHORIZATION_HEADER);
		}
		
		tokenService.validateJWT(token);

		return super.preHandle(request, response, handler);
	}
	
}