package com.bolsaideas.springboot.form.services;

import java.util.List;

import com.bolsaideas.springboot.form.editors.Role;

public interface RoleService {

	
	
	public List<Role> listar();
	
	public Role buscarPorId(Integer id) ;

	
}
