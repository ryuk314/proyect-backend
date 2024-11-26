package com.microcervice.oauth.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Component;

import com.microcervice.oauth.service.UsuarioService;
import com.microcervice.usuarios.commons.users.entity.Usuario;

@Component
public class infoadicionaltoken implements TokenEnhancer{
	private UsuarioService service;
	
	public OAuthzAccessToken enhance(OAuthzAccessToken accessToken,OAuthAutentification autentification) {
		Map<String,Object> info = new HashMap<>();
		
		Usuario user = service.findByUsername(Authentication.getUsername());
		info.put("nombre", user.getNombre());
		info.put("apellido", user.getApellido());
		info.put("correo", user.getEmaill());
		info.put("ClaimPrueba", "valor de prueba");
		
		((DefaultOAuthzAccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}
	
}
