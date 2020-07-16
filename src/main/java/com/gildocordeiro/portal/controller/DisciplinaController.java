package com.gildocordeiro.portal.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gildocordeiro.portal.domain.Disciplina;
import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.dto.DisciplinaDTO;
import com.gildocordeiro.portal.service.DisciplinaService;
import com.gildocordeiro.portal.service.UsuarioService;

@Controller
@EnableAutoConfiguration
public class DisciplinaController {

	ModelAndView model;
	
	@Autowired
	private DisciplinaService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired protected ServletContext servletContext;

	
	@GetMapping(value = "/disciplinas")
	public ModelAndView recuperarDisciplinas() {
		model = new ModelAndView("disciplina/disciplinas.html");
		model.addObject("disciplinas", service.findAll());
		return model;
	}

	@GetMapping(value = "/disciplinas/nova-disciplina")
	public ModelAndView cadastrarDisciplinasView() {
		model = new ModelAndView("disciplina/cadastrar-disciplina.html");
		model.addObject("disciplinaDTO", new DisciplinaDTO());
		model.addObject("professores", usuarioService.findTeacher());
		return model;
	}

	@PostMapping(value = "/disciplina/nova-disciplina/salvar")
	public ModelAndView salvarDisciplina(@ModelAttribute(value = "disciplinaDTO") DisciplinaDTO disciplinaDTO, @RequestParam("user") Usuario user) {
		
		Set<Usuario> lista = new HashSet<>();
		
		Optional<Usuario> u = usuarioService.findById(disciplinaDTO.getUser());
		
		lista.add(u.get());
		
		Disciplina disciplina = new Disciplina(disciplinaDTO.getCodigo(), disciplinaDTO.getNome(),
				disciplinaDTO.getDescricao(),disciplinaDTO.getSemestre(), lista);
		
		service.salvar(disciplina);
		model = new ModelAndView("redirect:/disciplinas/nova-disciplina");
		return model;
	}
}
