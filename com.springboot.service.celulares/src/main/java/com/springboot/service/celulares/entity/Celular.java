package com.springboot.service.celulares.entity;

import javax.xml.bind.annotation.XmlID;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table
public class Celular implements Serializable{

	private static final long serialVersionUID = 8211789171804203078L;
	@XmlID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	   private long id;
	   private String name;
	   private String marca;

	   @Column(name="create_at")
	   @Temporal(TemporalType.TIMESTAMP)
	   private Date CrateAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getCrateAt() {
		return CrateAt;
	}

	public void setCrateAt(Date crateAt) {
		CrateAt = crateAt;
	}
	   
	   
}

