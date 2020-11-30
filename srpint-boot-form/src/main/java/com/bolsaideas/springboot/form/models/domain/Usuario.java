package com.bolsaideas.springboot.form.models.domain;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import com.bolsaideas.springboot.form.editors.Role;
import com.bolsaideas.springboot.form.validation.IdentificadorRegex;
import com.bolsaideas.springboot.form.validation.Requerido;

public class Usuario {
	
	
	
	@IdentificadorRegex
	private String identificador;
	
	//@NotEmpty
	private String nombre;
	//@NotEmpty
	@Requerido
	private String apellido;
	
    @NotBlank
    @Size(min =3, max=22)
	private String username;
    @NotEmpty
	private String password;

    @Email
	private String email;
    
    
    @NotNull
    //@Past
    @Future
    //@DateTimeFormat(pattern  = "yyyy-MM-dd")
    private Date fechaNacimiento;
    
    @NotNull
    @Min(5)
    @Max(5000)
    private Integer cuenta;
    
    
    @NotEmpty
    private List<Role> roles;
    
    
    private Boolean habilitarUsuario;
    
    
    @NotEmpty
    private String sexo;
    
    private Pais pais;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public Integer getCuenta() {
		return cuenta;
	}
	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Boolean getHabilitarUsuario() {
		return habilitarUsuario;
	}
	public void setHabilitarUsuario(Boolean habilitarUsuario) {
		this.habilitarUsuario = habilitarUsuario;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
