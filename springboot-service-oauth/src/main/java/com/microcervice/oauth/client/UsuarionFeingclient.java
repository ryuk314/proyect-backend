package com.microcervice.oauth.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microcervice.usuarios.commons.users.entity.Usuario;



@EnableFeignClients("servicio-usuarios")
public  interface UsuarionFeingclient{
	
	@GetMapping("/usuarios/search/buscar-username")
	public static Usuario FindByUsername(@RequestParam String username) {
		
		return null;
	}
}
