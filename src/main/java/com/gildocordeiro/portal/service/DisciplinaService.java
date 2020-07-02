package com.gildocordeiro.portal.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gildocordeiro.portal.domain.Disciplina;
import com.gildocordeiro.portal.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;

	public void salvar(Disciplina disciplina, MultipartFile MultFile, String Path) throws IOException {
		if (MultFile != null && !MultFile.isEmpty()) {
			try {
				String d = diretorio();
				FileOutputStream out = new FileOutputStream(d+MultFile.getOriginalFilename());
				out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

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
