package com.bolsaideas.springboot.form.services;

import java.util.List;

import com.bolsaideas.springboot.form.models.domain.Pais;

public interface PaisService {

	
	public List<Pais> listar();
	
	
	public Pais obtenerPorId(Integer id);
}
