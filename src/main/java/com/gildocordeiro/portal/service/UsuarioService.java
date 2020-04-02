package com.gildocordeiro.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.domain.enums.TipoUsuario;
import com.gildocordeiro.portal.repository.UsuarioRepository;

@Service
public class UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void salvarUsuario(Usuario usuario) {
		
		if(usuario.getTipo().equals(TipoUsuario.PROFESSOR.getCodigo())) {
			usuario.setTipo(TipoUsuario.PROFESSOR);
			
		}else if(usuario.getTipo().equals(TipoUsuario.ALUNO.getCodigo())) {
			usuario.setTipo(TipoUsuario.ALUNO);
			
		}else {
			usuario.setTipo(TipoUsuario.ADMINISTRADOR);
		}
		usuarioRepository.save(usuario);
	}

}
