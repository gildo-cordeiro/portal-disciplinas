package com.gildocordeiro.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
	
	ModelAndView model;
	
	@RequestMapping("/")
	public ModelAndView inicio(){
		model = new ModelAndView("index.html");
		return model;
	}
}
