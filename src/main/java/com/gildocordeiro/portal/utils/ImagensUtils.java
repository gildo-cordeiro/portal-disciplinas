package com.gildocordeiro.portal.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImagensUtils {
	
	public void salva(MultipartFile imagem) {	
		File destino = new File(diretroio()+"/", imagem.getOriginalFilename());
		try {
			IOUtils.copyLarge(imagem.getInputStream(), new FileOutputStream(destino));
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
			diretorio = "/tmp/application/portal/";
		}
		
		File makeDireorio = new File(diretorio);
		
		if(!makeDireorio.exists()) {
			makeDireorio.mkdir();
		}		
		return diretorio;
	}

}