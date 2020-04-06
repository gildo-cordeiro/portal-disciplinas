package com.gildocordeiro.portal.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gildocordeiro.portal.domain.Usuario;
import com.gildocordeiro.portal.domain.enums.TipoUsuario;

public class MyUserDetails implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String senha;
	private boolean ativo;
	private List<GrantedAuthority> autotity;
	
	public Set<String> tipos(){
		Set<String> tipo = new HashSet<>();
		for (TipoUsuario usuario : TipoUsuario.values()) {
			tipo.add(usuario.getDescricao().toLowerCase());
		}
		return tipo;
	}
	
	
	public MyUserDetails(Optional<Usuario> user) {
		this.userName = user.get().getUserName();
		this.senha = user.get().getSenha();
		this.ativo = user.get().isAtivo();
		this.autotity = Arrays.stream(TipoUsuario.getDesc(user.get().getTipo()).toString()
				.toLowerCase().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return autotity;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return ativo;
	}
}
