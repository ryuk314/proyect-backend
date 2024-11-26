package com.microcervice.oauth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.realm.JNDIRealm.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microcervice.oauth.client.UsuarionFeingclient;
import com.microcervice.usuarios.commons.users.entity.Usuario;
@Service
public class UsuarioService implements UserDetailsService,IUsuarioService{
	
	private Logger log = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarionFeingclient client;
	
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
		
		UsuarioService user = client.FindByUsername(username);
		
		if (user==null) {
			log.error("Error en el loggin, no existe el usuario" + username);
			throw new UsernameNotFoundExcention("Error en el loggin, no existe el usuario" + username);
		}
		
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> log.info("Role: "+authority.getAuthority()))
				.colect(Collectors.toList());
		log.info("Usuario autenticado" + username);
		
		return new User(user.getUsername(),user.getPasword(),user.getEnable(),true,true,true,authorities);
	}
	
	public Usuario findByUsername(String username) {
		return client.FindByUsername(username);
	}
}
