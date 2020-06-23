package com.gildocordeiro.portal.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.security.MyUserDetails;

public class UsuarioLogado{
	
	private Usuario usuario;	
	
	public UsuarioLogado(){
		usuario = new Usuario();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			 usuario.setUserName(((MyUserDetails) authentication.getPrincipal()).getUsername());
			 usuario.setAtivo(((MyUserDetails) authentication.getPrincipal()).isEnabled());
			 usuario.setSenha(((MyUserDetails) authentication.getPrincipal()).getPassword());
			 usuario.setPath_image(((MyUserDetails) authentication.getPrincipal()).getPath_image());
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
