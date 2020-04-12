package com.gildocordeiro.portal.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UsuarioDTO {
	
	@NotEmpty(message = "Nome vazio")
	private String nome;
	
	@Email(message = "E-mail mal formatado")
	private String email;
	
	@NotBlank(message = "Username vazio")
	private String userName;
	
	@NotBlank(message = "Senha vazia")
	private String senha;
	
	@NotBlank(message = "Senha vazia")
	private Integer perfil;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}	
}
