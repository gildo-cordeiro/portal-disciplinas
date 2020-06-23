package com.gildocordeiro.portal.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gildocordeiro.portal.domain.enums.Perfil;

public class MyUserDetails implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String login;
	private String senha;
	private boolean ativo;
	private String path_image;
	private Collection<GrantedAuthority> permissoes = new ArrayList<>();
	
	public MyUserDetails(String nome, String login,	String senha, boolean ativo, Set<Perfil> perfis, String path_image) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.ativo = ativo;
		this.path_image = path_image;
		this.permissoes = perfis.stream().map(p -> new SimpleGrantedAuthority(p.getDescricao())).collect(Collectors.toSet());
	}

	public String getNome() {
		return nome;
	}
	
	public String getPath_image() {
		return path_image;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return permissoes;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return ativo;
	}	
}
