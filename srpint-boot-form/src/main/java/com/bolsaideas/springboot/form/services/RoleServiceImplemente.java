package com.bolsaideas.springboot.form.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsaideas.springboot.form.editors.Role;

@Service
public class RoleServiceImplemente implements RoleService{

	
	private List<Role> roles;
	
	
	
	public RoleServiceImplemente() {
		roles = new ArrayList<>();
		
		roles.add(new Role(1,"Administrador","ROLE_ADMIN"));
		roles.add(new Role(2,"Usuario","ROLE_USER"));
		roles.add(new Role(3,"Moderador","ROLE_MODERATOR"));
		

	}

	@Override
	public List<Role> listar() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public Role buscarPorId(Integer id) {
		Role resultado = null;
		
		for(Role auxSearch : roles) {
			if(auxSearch.getId() == id) {
				resultado = auxSearch;
				break;
			}
		}
		
		return resultado;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
	
}
