package com.bolsaideas.springboot.form.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsaideas.springboot.form.models.domain.Pais;


@Service
public class PaisServiceImplement implements PaisService {

	
	private List<Pais> lista;
	
	public PaisServiceImplement() {
		this.lista = Arrays.asList( new Pais(1, "ES","España"),
				new Pais(2, "MX","Mexico"),
				new Pais(3, "CL","Chile"),
				new Pais(4, "AR","Argentina"),
				new Pais(5, "PE","Peru"),
				new Pais(6, "CO","Colombia"),
				new Pais(7, "VE","Venezuela"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pais> listar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		Pais resultado = null;
		
		for(Pais pais : this.lista) {
			
			if(id == pais.getId()) {
				resultado = pais;
				break;
			}
		}
		
		return resultado;
	}

}
