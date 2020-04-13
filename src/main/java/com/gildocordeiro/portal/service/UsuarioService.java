package com.gildocordeiro.portal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.domain.enums.Perfil;
import com.gildocordeiro.portal.dto.UsuarioDTO;
import com.gildocordeiro.portal.repository.UsuarioRepository;

@Service
public class UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	public String salvarUsuario(Usuario usuario) {
		Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(usuario.getEmail());
		if (usuarioEncontrado.isPresent()) {
			return "E-mail já cadastrado";
		}
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuario);
		return "Usuario cadastrado com sucesso";
	}
	
	public Usuario converteFromUser(UsuarioDTO form) {
		Usuario user = new Usuario(form.getNome(), form.getEmail(), form.getUserName(), 
				form.getSenha(), true, Perfil.getPerfil(form.getPerfil()));
		return user;
	}
}
