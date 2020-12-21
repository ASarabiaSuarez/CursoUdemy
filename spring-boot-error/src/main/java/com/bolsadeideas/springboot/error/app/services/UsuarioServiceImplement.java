package com.bolsadeideas.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImplement implements UsuarioService {

	
	private List<Usuario> lista;
	
	
	public UsuarioServiceImplement() {
		this.lista = new ArrayList();
		this.lista.add(new Usuario(1,"Andrès","Guzmán"));
		this.lista.add(new Usuario(2,"Pepa","Garciía"));
		this.lista.add(new Usuario(3,"Lalo","Mena"));
		this.lista.add(new Usuario(4,"Luci","Fernández"));
		this.lista.add(new Usuario(5,"Pato","González"));
		this.lista.add(new Usuario(6,"Paco","Rodríguez"));	
		this.lista.add(new Usuario(7,"Juan","Gómez"));
	}

	@Override
	public List<Usuario> listar() {
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null;
		for(Usuario buscandoId : this.lista) {
			
			if(buscandoId.getId_().equals(id)) {
				resultado = buscandoId;
				return resultado;
			}
		}
		return resultado;
	}
	

}
