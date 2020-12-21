package com.bolsadeideas.springboot.error.app.controllers;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

	
	
	@ExceptionHandler(ArithmeticException.class)
	public String aritmeticoError (ArithmeticException ex, Model model) {
		
		
		model.addAttribute("error", "Error de arimetica");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		
		return "error/aritmetica";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String numberFormatException (NumberFormatException ex, Model model) {
		
		
		model.addAttribute("error", "Error formato de numero incorrecto");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		
		return "error/numberFormatException";
	}
	
}
