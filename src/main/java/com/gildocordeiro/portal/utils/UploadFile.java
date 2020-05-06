package com.gildocordeiro.portal.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

	@Autowired
	private ServletContext context;
	private BufferedInputStream in;

	public String uploadImagem(MultipartFile img) throws Exception {

		String path = context.getRealPath("/resources/imagens/thumb/");

		try {

			String fileName = img.getName();
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

		return "";
	}
}
