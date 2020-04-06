package com.gildocordeiro.portal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {

	ModelAndView model;
	
	@GetMapping
	public ModelAndView index() {
		model = new ModelAndView("aluno/userPage.html");
		return model;
	}
}
