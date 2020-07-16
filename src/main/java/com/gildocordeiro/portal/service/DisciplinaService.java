package com.gildocordeiro.portal.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gildocordeiro.portal.domain.Disciplina;
import com.gildocordeiro.portal.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;

	public void salvar(Disciplina disciplina){
		repository.save(disciplina);
	}
	
	public List<Disciplina> findAll(){
		return repository.findAll();
	}
	

	public String diretorio() {
		File raiz = new File("C:/");
		String diretorio = "";

		if (raiz.exists()) {
			diretorio = "C:/application/portal/";
		} else {
			diretorio = "~/application/portal/";
		}

		File makeDireorio = new File(diretorio);

		if (!makeDireorio.exists()) {
			makeDireorio.mkdir();
		}
		return diretorio;
	}
}
