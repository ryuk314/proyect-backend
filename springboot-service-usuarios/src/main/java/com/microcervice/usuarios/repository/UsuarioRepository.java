package com.microcervice.usuarios.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.microcervice.usuarios.commons.users.entity.Usuario;

import feign.Param;


@RepositoryRestResource(path="usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario,Long>{

	// select u from commons.user u Where u.username =?1
	@RestResource(Path ="buscar-username")
	public Usuario finByUsername( String username);
	
	// select u from Ususario u Where u.username =?
	public Usuario finByUsernameAndEmail(String username,String email);
	
	@Query(value="select u from Ususario u Where u.username =?1")
	public Usuario obtenerPOrUsername(String username);
	
	@Query(value="select u from Ususario u Where u.username =?1")
	public Usuario obtenerPOrUsernameAndEmail(String username,String email);
	
}
