package com.bolsaideas.springboot.form.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolsaideas.springboot.form.services.PaisServiceImplement;


@Component
public class PaisPropertiEditors extends PropertyEditorSupport {

	
	@Autowired
	private PaisServiceImplement paisService;
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		if(( text != null )  && ( text.length() > 0 )) {
			super.setValue( paisService.obtenerPorId( Integer.parseInt( text)));
		}
	}

}
