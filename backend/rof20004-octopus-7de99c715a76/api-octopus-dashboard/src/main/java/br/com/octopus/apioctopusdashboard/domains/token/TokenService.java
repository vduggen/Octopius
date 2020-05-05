package br.com.octopus.apioctopusdashboard.domains.token;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.octopus.apioctopusdashboard.exceptions.AuthException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	private static final String KEY = "0ct0pu5";
	private static final long EXPIRATION_TIME = 1000L * 60 * 30;
	
	public TokenDTO generateJWT(String username) throws AuthException {
		Date expiration = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
		Claims claims = Jwts.claims().setSubject(username);
		
		String token = Jwts.builder().setClaims(claims).setExpiration(expiration).signWith(SignatureAlgorithm.HS256, KEY).compact();
		
		return TokenDTO.builder().token(token).build();
	}
	
	public String validateJWT(String token) throws AuthException {
		try {
			return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody().getSubject();
		} catch (Exception e) {
			throw new AuthException("Token inválido");
		}
	}
	
}
