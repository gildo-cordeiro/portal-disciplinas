package com.gildocordeiro.portal.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gildocordeiro.portal.domain.Disciplina;
import com.gildocordeiro.portal.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;
	
	public void salvar(Disciplina disciplina, MultipartFile MultFile) {
		String dir = diretroio();
		String link = dir+"/"+MultFile.getOriginalFilename();
		
		try {			
			IOUtils.copyLarge(MultFile.getInputStream(), new FileOutputStream(dir));
			
			disciplina.getMultimidias().get(0).setLink(link);
			repository.save(disciplina);
		} catch (IOException e) {

			throw new RuntimeException("Erro ao copiar imagem", e);
		}
	
	}
	public String diretroio() {
		File raiz = new File("C:/");
		String diretorio = "";	
		
		if (raiz.exists()) {
			diretorio = "C:/application/portal/";
		}else{
			diretorio = "/home/application/portal/";
		}
		
		File makeDireorio = new File(diretorio);
		
		if(!makeDireorio.exists()) {
			makeDireorio.mkdir();
		}		
		return diretorio;
	}
}
