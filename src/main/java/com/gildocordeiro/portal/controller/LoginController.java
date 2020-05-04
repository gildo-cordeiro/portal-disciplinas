package com.gildocordeiro.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.dto.UsuarioDTO;
import com.gildocordeiro.portal.service.UsuarioService;
import com.gildocordeiro.portal.utils.UsuarioLogado;

@RestController
public class LoginController {
	
	ModelAndView model;
	

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/login")
	public ModelAndView login() {
		model = new ModelAndView("login/loginForm.html");
		model.addObject("usuario", new Usuario());
		return model;
	}
	
	@GetMapping(value = "/registrar")
	public ModelAndView registrar(@RequestParam(value = "msg", required = false) String msg) {
		model = new ModelAndView("login/registrarForm.html");
		model.addObject("form", new UsuarioDTO());
		model.addObject("msg", msg);
		return model;
	}
	
	@PostMapping(value = "/salvarUsuario")
	public ModelAndView salvarUsuario(@ModelAttribute(value = "form") UsuarioDTO form, BindingResult bindingResult) {
		Usuario usuario = usuarioService.converteFromUser(form);
		String message = usuarioService.salvarUsuario(usuario);

		model = new ModelAndView("redirect:registrar");
		model.addObject("usuario", new Usuario());
		model.addObject("msg", message);

		return model;
	}
	
	@GetMapping("/professor")
	public ModelAndView prof() {
		model = new ModelAndView("professor.html");
		return model;
	}
	
	@PostMapping(value= "/autenticarUsuario")
	public ModelAndView autenticaUsuario() {
		UsuarioLogado user = new UsuarioLogado();
		model = new ModelAndView("redirect:"+user.getUsuario().getUserName().toString());
		return model;
	}
	
	@GetMapping(value = "/unauthorized-page")
    public ModelAndView unauthorizedPage() {
    	model = new ModelAndView("pages/403.html");
    	return model;
    }
	
	
	@GetMapping(value = "/{username}")
	public ModelAndView dashUser(@PathVariable String username) {
		UsuarioLogado user = new UsuarioLogado();
		if (username.equals(user.getUsuario().getUserName())) {
			model = new ModelAndView("dash.html");
		}else {
			model = new ModelAndView("pages/404.html");
		}
		return model;
	}
	
}