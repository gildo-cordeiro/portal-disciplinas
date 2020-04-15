package com.gildocordeiro.portal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.repository.UsuarioRepository;
import com.gildocordeiro.portal.security.MyUserDetails;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> u = usuarioRepository.findByUserName(username);

		return new MyUserDetails(u.get().getNome(), u.get().getUserName(), 
				u.get().getSenha(), u.get().isAtivo(),u.get().getPerfis());
	}

}
