package com.gildocordeiro.portal.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gildocordeiro.portal.domain.Disciplina;

@Service
public class DisciplinaService {

	private BufferedInputStream in;

	public void salvar(Disciplina disciplina, MultipartFile MultFile, String path) throws Exception {
		
		try {
			String fileName = MultFile.getName();
			String arq[] = fileName.split("\\\\");
			for (int i = 0; i < arq.length; i++) {
				fileName = arq[i];
			}

			File file = new File(path, fileName);
			FileOutputStream out = new FileOutputStream(file);

			in = new BufferedInputStream(new FileInputStream(file));

			// Imagens de até 2 megas !!
			byte[] buffer = new byte[1024 * 7];
			int nLidos;
			while ((nLidos = in.read(buffer)) >= 0) {
				out.write(buffer, 0, nLidos);
			}

			out.flush();
			out.close();
		} catch (Exception e) {
			throw new Exception("Erro ao carregar imagem para o diretorio !!\n " + "Error : " + e.getMessage()
					+ "\nCausa : " + e.getCause());

		}
	}
}

