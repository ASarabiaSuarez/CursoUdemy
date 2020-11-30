package com.bolsaideas.springboot.form.editors;

import java.beans.PropertyEditorSupport;

public class NombreMayusculaEditors extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		setValue(text.toUpperCase());
	}

	
	
}
