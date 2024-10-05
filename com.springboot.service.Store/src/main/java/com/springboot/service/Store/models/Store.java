package com.springboot.service.Store.models;

public class Store {
	
	private Celular cel;
	public Store() {
		
	}
	
	public Store(Celular cel, Integer cantidad) {
		super();
		this.cel = cel;
		this.cantidad = cantidad;
	}

	private Integer cantidad;

	public Celular getCel() {
		return cel;
	}

	public void setCel(Celular cel) {
		this.cel = cel;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
