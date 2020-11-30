package com.bolsaideas.springboot.form.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolsaideas.springboot.form.services.RoleService;



@Component
public class RolesEditors extends PropertyEditorSupport {

	@Autowired
	private RoleService service;
	
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		
		try {
			
			Integer id = Integer.parseInt(text);
			setValue(service.buscarPorId(id));
			
		} catch (NumberFormatException e) {
			setValue(null);
		}
		
	}
	
	
	

}
