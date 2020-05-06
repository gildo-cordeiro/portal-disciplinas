package com.gildocordeiro.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
public class DisciplinaController {

	ModelAndView model;
	
	@Autowired
	private DisciplinaService service;

	@GetMapping(value = "/disciplinas")
	public ModelAndView recuperarDisciplinas() {
		model = new ModelAndView("disciplina/disciplinas.html");
		return model;
	}

	@GetMapping(value = "/disciplinas/nova-disciplina")
	public ModelAndView cadastrarDisciplinasView() {
		model = new ModelAndView("disciplina/cadastrar-disciplina.html");
		model.addObject("disciplina", new DisciplinaDTO());
		return model;
	}

	@PostMapping(value = "nova-disciplina/salvar")
	public void salvarDisciplina(@ModelAttribute(value = "disciplina") DisciplinaDTO disciplinaDTO,
			@RequestParam(value = "file") MultipartFile file, RedirectAttributes redirectAttributes) {
		
		Multimidia mult = new Multimidia(file.getOriginalFilename(), null, TipoMultimidia.IMG.getCodigo(), true);
		
		Disciplina disciplina = new Disciplina(disciplinaDTO.getCodigo(), disciplinaDTO.getNome(),
				disciplinaDTO.getDescricao(), mult);
		
		service.salvar(disciplina, file);		
	}
}
