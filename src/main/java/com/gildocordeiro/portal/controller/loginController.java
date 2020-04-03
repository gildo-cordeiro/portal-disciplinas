package com.gildocordeiro.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.service.UsuarioService;

@RestController
public class loginController {
	
	ModelAndView model;

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		model = new ModelAndView("login/loginForm.html");
		model.addObject("usuario", new Usuario());
		return model;
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.GET)
	public ModelAndView registrar() {
		model = new ModelAndView("login/registrarForm.html");
		model.addObject("usuario", new Usuario());
		return model;
	}
	
	@RequestMapping(value = "/salvarUsuario", method = RequestMethod.POST)
	public ModelAndView salvarUsuario(@ModelAttribute(value = "usuario") Usuario usuario, BindingResult bindingResult) {
		usuarioService.salvarUsuario(usuario);
		model = new ModelAndView("login/loginForm.html");
		model.addObject("usuario", new Usuario());
		return model;
	}
}