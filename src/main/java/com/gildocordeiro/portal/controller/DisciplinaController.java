package com.gildocordeiro.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DisciplinaController {
	
	ModelAndView model;
	
	@GetMapping(value = "/disciplinas")
	public ModelAndView recuperarDisciplinas() {
		model = new ModelAndView("disciplina/disciplinas.html");
		return model;
	}
}
