package com.gildocordeiro.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PerfilController {
	ModelAndView model;
	
	@GetMapping(value = "/perfil")
	public ModelAndView login() {
		model = new ModelAndView("painel-usuario/perfiluser.html");
		return model;
	}
	

}
