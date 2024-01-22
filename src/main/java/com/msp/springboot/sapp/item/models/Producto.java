package com.msp.springboot.sapp.item.models;

import java.util.Date;

//es un objeto en el que vamos a poblar los datos del JSON, no es un entity no esta mappeado a ninguna tabla

public class Producto {
	
	private Long id;
	
	private String nombre;
	
	private Double precio;
	
	private Date createAt;
	
	private Integer port;
	
	
	
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	

}
