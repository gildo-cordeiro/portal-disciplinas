package com.gildocordeiro.portal.configs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.repository.UsuarioRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Usuario> user= usuarioRepository.findByUserName(userName);
		return new MyUserDetails(user);
	}

}
