package com.gildocordeiro.portal.service;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.domain.enums.TipoUsuario;
import com.gildocordeiro.portal.repository.UsuarioRepository;
import com.gildocordeiro.portal.utils.MyUserDetails;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
		
	public void salvarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public String autenticarUsuario(Usuario usuario) {
		if (verificandoUsario(usuario)) {
			String b = null;
			UserDetails a = loadUserByUsername(usuario.getEmail());
			Iterator<?> iterator = a.getAuthorities().iterator();
			while (iterator.hasNext()) {
				b = iterator.next().toString();			
			}
			return b;
		}
		return "";		
	}
	
	public boolean verificandoUsario(Usuario usuario) {
		if(usuario == null)
			return false;
		
		if(usuario.getEmail().equals("") || usuario.getSenha().equals(""))
			return false;
		
		return true;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> user = usuarioRepository.findByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found" + user.get().getUserName()));
		return new MyUserDetails(user);
	}


}
