package com.gildocordeiro.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.service.UsuarioService;

@Controller
public class PerfilController {
	ModelAndView model;
	
	@Autowired
	private UsuarioService usuario;
	
	@GetMapping(value = "/perfil")
	public ModelAndView login() {
		model = new ModelAndView("painel-usuario/perfiluser.html");
		model.addObject("usuario", new Usuario());
		return model;
	}
	

}
