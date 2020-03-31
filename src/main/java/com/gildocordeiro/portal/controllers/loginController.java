package com.gildocordeiro.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {
	@GetMapping("/layout/formLogin.html")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("/layout/loginForm.html");
		return model;
		
	}
	
}
