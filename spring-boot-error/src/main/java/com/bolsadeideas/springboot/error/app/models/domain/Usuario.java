package com.bolsadeideas.springboot.error.app.models.domain;

public class Usuario {

	private Integer id_;
	private String nombre;
	private String apellido;

	public Usuario() {
	}

	public Usuario(Integer id_, String nombre, String apellido) {

		this.id_ = id_;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Integer getId_() {
		return id_;
	}

	public void setId_(Integer id_) {
		this.id_ = id_;
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

}
