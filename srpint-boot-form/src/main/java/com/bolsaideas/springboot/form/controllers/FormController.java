package com.bolsaideas.springboot.form.controllers;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsaideas.springboot.form.editors.NombreMayusculaEditors;
import com.bolsaideas.springboot.form.editors.PaisPropertiEditors;
import com.bolsaideas.springboot.form.editors.Role;
import com.bolsaideas.springboot.form.editors.RolesEditors;
import com.bolsaideas.springboot.form.models.domain.Pais;
import com.bolsaideas.springboot.form.models.domain.Usuario;
import com.bolsaideas.springboot.form.services.PaisService;
import com.bolsaideas.springboot.form.services.PaisServiceImplement;
import com.bolsaideas.springboot.form.services.RoleService;
import com.bolsaideas.springboot.form.services.RoleServiceImplemente;
import com.bolsaideas.springboot.form.validation.UsuarioValidation;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidation validador;
	
	@Autowired
	private PaisServiceImplement paisService;
	
	@Autowired
	private PaisPropertiEditors paisEditor;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RolesEditors rolesEDitors;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
		binder.registerCustomEditor(Date.class,"fechaNacimiento" ,new CustomDateEditor(dateFormat,false));
		
		binder.registerCustomEditor(String.class   ,"nombre" , new NombreMayusculaEditors());
		
		binder.registerCustomEditor(Pais.class, "pais", paisEditor);
		
		binder.registerCustomEditor(Role.class, "roles", rolesEDitors);
	}
	
	@GetMapping("/form")
	public String form(Model model ) {
		Usuario usuario = new Usuario();
		usuario.setNombre("John");
		usuario.setApellido("Doe");
		usuario.setIdentificador("24.573.238-K");
		usuario.setHabilitarUsuario(true);
		usuario.setPais( new Pais(3, "CL","Chile"));
		usuario.setRoles(Arrays.asList(new Role(1,"Administrador","ROLE_ADMIN")));
		model.addAttribute("titulo", "crear usuario");
		model.addAttribute("usuario", usuario ); 
		return "form";
	}
	
	
	@ModelAttribute("listaSexo")
	public List<String> listarSexo(){
		
		return Arrays.asList("Hombre","Mujer");
		
	}
	
	@ModelAttribute("listaRoles")
	public List<Role> listaRoles(){
		return  this.roleService.listar();
	}
	
	@ModelAttribute("listaRolesString")
	public List<String> listaRolesString(){
		List<String> roles = new ArrayList<String>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");
		return roles;
	}
	
	@ModelAttribute("listaRolesMap")
	public Map<String,String> listaRolesMap(){
		Map<String,String> paises = new HashMap<>();
		paises.put("ROLE_ADMIN", "Administrador");
		paises.put("ROLE_USER", "Usuario");
		paises.put("ROLE_MODERATOR", "Moderador");
		
	
		return  paises;
	}
	
	
	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises(){
		return this.paisService.listar();
	}
	
	@ModelAttribute("paises")
	public List<String> paises(){
		return Arrays.asList("España","Mexico","Chile","Argentina","Peru","Colombia","Venezuela");
	}
	
	
	
	
	@ModelAttribute("paisesMap")
	public Map<String,String> paisesMap(){
		Map<String,String> paises = new HashMap<>();
		paises.put("ES", "España");
		paises.put("MX", "MEXICO");
		paises.put("AR", "Argentina");
		paises.put("pe", "Peru");
		paises.put("VE", "Venezuela");
		paises.put("CO", "Colombia");
	
		return  paises;
	}
	
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario ,BindingResult result,Model model, SessionStatus status) {
        //validador.validate(usuario, result);
		model.addAttribute("titulo", "resultado del formulario");
		if(result.hasErrors()) {
		
			/*Map<String,String> errores = new HashMap<>();
			result.getFieldErrors().forEach(error -> {
				errores.put(error.getField() ,  "El campo ".concat(error.getField()).concat(" ").concat(error.getDefaultMessage()));
			});
			model.addAttribute("error", errores);*/
			
			//System.out.println(result);
			return "form";
		}
		model.addAttribute("usuario",usuario);
		status.setComplete();
		return "resultado";
	}
	
}
