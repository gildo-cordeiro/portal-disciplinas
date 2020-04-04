package com.gildocordeiro.portal.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	ModelAndView model;
	
	@Secured("USER")
	@RequestMapping(value = {"/","/inicio"})
	
	public ModelAndView inicio(){
		model = new ModelAndView("index.html");
		return model;
	}
	
	@RequestMapping(value = "/403")
    public String error403() {
        return "/error/403";
    }
}
