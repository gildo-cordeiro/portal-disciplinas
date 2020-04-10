package com.gildocordeiro.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.domain.dto.UsuarioDTO;
import com.gildocordeiro.portal.domain.enums.Perfil;
import com.gildocordeiro.portal.repository.UsuarioRepository;

@Service
public class UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	public void salvarUsuario(Usuario usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuario);
	}
	
	public Usuario converteFromUser(UsuarioDTO form) {
		Usuario user = new Usuario(form.getNome(), form.getEmail(), form.getUserName(), 
				form.getSenha(), true, Perfil.getPerfil(form.getPerfil()));
		return user;
	}
}
