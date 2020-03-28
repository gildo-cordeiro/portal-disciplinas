package com.gildocordeiro.portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gildocordeiro.portal.models.Usuario;
import com.gildocordeiro.portal.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public void saveUser(Usuario usuario) {
		if (usuario != null) {
			repository.save(usuario);
		}
	}

}
