package com.mypet.myPetApp.security;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Date;

import javax.servlet.FilterChain;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;

import org.springframework.security.core.AuthenticationException;

import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypet.myPetApp.dto.CredenciasDTO;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	private JWTUtil jwtUtil;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {

		setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;

	}

	@Override

	public Authentication attemptAuthentication(HttpServletRequest req,

			HttpServletResponse res) throws AuthenticationException {

		try {

			CredenciasDTO creds = new ObjectMapper().readValue(req.getInputStream(), CredenciasDTO.class); // pega os dados das credencias que veio na  requisição, e converte para tipo que estiver na class

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getEmail(),
					creds.getSenha(), new ArrayList<>()); // pegando os dados instancia ele com esse tipo

			Authentication auth = authenticationManager.authenticate(authToken); // quando instanciado chama esse metado, verifica se usurio é valido ou não atraves do UserDetails

			return auth;

		}

		catch (IOException e) {

			throw new RuntimeException(e);

		}

	}

	@Override

	protected void successfulAuthentication(HttpServletRequest req,
			HttpServletResponse res,
			FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		String username = ((UserSS) auth.getPrincipal()).getUsername(); //retorna um usuario
		String token = jwtUtil.generateToken(username); // gera um token para trafegar no cabeçalho da resposta
		res.addHeader("Authorization", "Bearer " + token); // nome do cabeçalho vai ser Authorization o valor sera Bearer + o token

	}

	private class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {

		@Override

		public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException exception)

				throws IOException, ServletException {

			response.setStatus(401);

			response.setContentType("application/json");

			response.getWriter().append(json());

		}

		private String json() {

			long date = new Date().getTime();

			return "{\"timestamp\": " + date + ", "

					+ "\"status\": 401, "

					+ "\"error\": \"Não autorizado\", "

					+ "\"message\": \"Email ou senha inválidos\", "

					+ "\"path\": \"/login\"}";

		}

	}

}
 