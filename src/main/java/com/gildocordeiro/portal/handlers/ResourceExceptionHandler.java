package com.gildocordeiro.portal.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ResourceExceptionHandler{
	
	ModelAndView model;

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView pageNotFound(Exception e) {
    	model = new ModelAndView("pages/404.html");
        model.addObject("message", e.getMessage());
    	return model;
    }
    
    @GetMapping(value = "/unauthorized-page")
    public ModelAndView unauthorizedPage() {
    	model = new ModelAndView("pages/unauthorized.html");
    	return model;
    }
    
}
