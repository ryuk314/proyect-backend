package com.microcervice.oauth.service;

import com.microcervice.usuarios.commons.users.entity.Usuario;

public interface IUsuarioService {
	public Usuario FindByUsername(String username);
}
