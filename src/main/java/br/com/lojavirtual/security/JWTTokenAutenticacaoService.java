package br.com.lojavirtual.security;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*Criar a autenticacao e retorna tembem a autenticacao JWT*/
@Service
@Component
public class JWTTokenAutenticacaoService {
	
	/*Token de validade de 11 dias*/
	private static final long EXPIRATION_TIME = 959990000;
	
	/*Chave de senha para juntar com JWT*/
	private static final String SECRET = "";
	
	private static final String TOKEN_PREFIX = "Bearer";
	
	private static final String HEADER_STRING = "Authorization";
	
	/*Gera o token e da a resposta para o cliente o com JWT*/
	public void addAuthentication(HttpServletResponse response, String username) throws Exception {
		
		/*Montagem do Token*/
		String JWT = Jwts.builder()./*Chama o gerador de token*/
				setSubject(username)/*Adiciona o user*/
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) /*Temp de expiração*/
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();/*chave de compactacao*/
		
		/*Ex: Bearer - asdsadasdasdsadad.sdsadsadsadsadsadsa.asdsadsadsadsads.asdsadsadd*/
		String token = TOKEN_PREFIX + " " + JWT;
		
		/*Dá a resposta pra tela e para o cliente, outra API, navegador, aplicativo, javascript, outra chamadajava*/
		response.addHeader(HEADER_STRING, token);
		
		/*Usado para ver no Postman para testes*/
		response.getWriter().write("{\"Authorization\": \"" + token + "\"}");
	}

}
