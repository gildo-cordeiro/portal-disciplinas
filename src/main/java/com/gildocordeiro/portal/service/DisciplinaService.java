package com.gildocordeiro.portal.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gildocordeiro.portal.domain.Disciplina;

@Service
public class DisciplinaService {

	public void salvar(Disciplina disciplina, MultipartFile MultFile, String path) throws Exception {

		try {
			String fileName = MultFile.getOriginalFilename();
            String arq[] = fileName.split("\\\\");
            for (int i = 0; i < arq.length; i++) {
                fileName = arq[i];
            }

            File file = new File(path,fileName);
            FileOutputStream out = new FileOutputStream(file);
            InputStream in = MultFile.getInputStream();    

            // Imagens de até 2 megas !!
            byte[] buffer = new byte[1024 * 2];
            int readBytes;
            while ((readBytes = in.read(buffer)) >= 0) {
                out.write(buffer, 0, readBytes);
            }
            in.read(buffer);
            out.flush();
            out.close();
        } catch (IOException e) {
			throw new Exception("Erro ao carregar imagem para o diretorio !!\n " + "Error : " + e.getMessage()
					+ "\nCausa : " + e.getCause());
		}
	}
}
