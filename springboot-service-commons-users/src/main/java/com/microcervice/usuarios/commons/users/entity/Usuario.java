package com.microcervice.usuarios.commons.users.entity;

import java.io.Serializable;
import java.util.List;

import javax.management.relation.Role;
import javax.persistence.JoinColumns;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")

public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2212971814811381579L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true, length = 20)
	private String username;
	
	@Column(unique = true, length = 100)
	private String email;
	
	@Column(length = 60)
	private String pasword;
	
	private Boolean Enable;
	
	private String nombre;
	
	private String apellido;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="usuarios_tu_roles",joinColumns = @JoinColumns(name ="user_id"),
	inverseJoinColumns = @JoinColumns(name = "rooles_id"),
	uniqueConstraints = @uniqueConstraints(ColumnName = ("user_id","rooles_id"));
	
	private List<Role> rooles;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
		
	}
	
	public void setUsername(String username) {
		this.username = username;
		}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPasword() {
	return pasword;
}

public void setPasword(String pasword) {
	this.pasword = pasword;
}

public Boolean getEnable() {
	return Enable;
}

public void setEnable(Boolean enable) {
	Enable = enable;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public List<Role> getRoles() {
	return rooles;
}

public void setRoles(List<Role> roles) {
	this.rooles = roles;
}


}
