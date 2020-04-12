package com.gildocordeiro.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.dto.UsuarioDTO;
import com.gildocordeiro.portal.service.UsuarioService;

@RestController
public class loginController {
	
	ModelAndView model;

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/login")
	public ModelAndView login() {
		model = new ModelAndView("login/loginForm.html");
		model.addObject("usuario", new Usuario());
		return model;
	}
	
	@GetMapping(value = "/adm")
	public ModelAndView adm() {
		model = new ModelAndView("adm.html");
		return model;
	}
	
	@GetMapping(value = "/registrar")
	public ModelAndView registrar() {
		model = new ModelAndView("login/registrarForm.html");
		model.addObject("form", new UsuarioDTO());
		return model;
	}
	
	@PostMapping(value = "/salvarUsuario")
	public ModelAndView salvarUsuario(@ModelAttribute(value = "form") UsuarioDTO form,BindingResult bindingResult) {
		form.setUserName("gildo.duarte");
		Usuario usuario = usuarioService.converteFromUser(form);
		usuarioService.salvarUsuario(usuario);
		
		model = new ModelAndView("login/loginForm.html");
		model.addObject("usuario", new Usuario());
		return model;
	}
	
	@PostMapping(value= "/autenticarUsuario")
	public ModelAndView autenticaUsuario() {
		model = new ModelAndView("redirect: adm");
		
		return model;
	}
	
}
