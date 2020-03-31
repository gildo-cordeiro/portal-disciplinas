package com.gildocordeiro.portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.repositories.UsuarioImplRepository;

@Service
public class UsuarioService{
	
	@Autowired
	private UsuarioImplRepository implRepository;
	
	
	public void salvarUsuario(Usuario usuario) {
		implRepository.salvar(usuario);
	}

}
