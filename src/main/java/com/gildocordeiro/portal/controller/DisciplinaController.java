package com.gildocordeiro.portal.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gildocordeiro.portal.domain.Disciplina;
import com.gildocordeiro.portal.domain.Multimidia;
import com.gildocordeiro.portal.domain.enums.TipoMultimidia;
import com.gildocordeiro.portal.dto.DisciplinaDTO;
import com.gildocordeiro.portal.service.DisciplinaService;

@Controller
@EnableAutoConfiguration
public class DisciplinaController {

	ModelAndView model;
	
	@Autowired
	private DisciplinaService service;
	
	@Autowired protected ServletContext servletContext;
	
	

	@GetMapping(value = "/disciplinas")
	public ModelAndView recuperarDisciplinas() {
		model = new ModelAndView("disciplina/disciplinas.html");
//		System.out.println("servletcontext: "+servletContext.getRealPath("/webapp/resources/imagens/thumb/"));
		return model;
	}

	@GetMapping(value = "/disciplinas/nova-disciplina")
	public ModelAndView cadastrarDisciplinasView() {
		model = new ModelAndView("disciplina/cadastrar-disciplina.html");
		model.addObject("disciplinaDTO", new DisciplinaDTO());
		return model;
	}

	@PostMapping(value = "/disciplina/nova-disciplina/salvar", consumes = "multipart/form-data")
	public void salvarDisciplina(@ModelAttribute(value = "disciplinaDTO") DisciplinaDTO disciplinaDTO,
			@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		
		Disciplina disciplina = new Disciplina(disciplinaDTO.getCodigo(), disciplinaDTO.getNome(),
				disciplinaDTO.getDescricao(), converteFromMultipart(file));
		
		try {
			service.salvar(disciplina, file, servletContext.getContextPath());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public Multimidia converteFromMultipart(MultipartFile file) {
		Multimidia m = new Multimidia(file.getOriginalFilename(), "", TipoMultimidia.IMG.getCodigo(), true);
		return m;
	}
}
