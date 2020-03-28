package com.gildocordeiro.portal.models;

import javax.persistence.Entity;

@Entity
public class Aluno extends Usuario{
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	private Float notas_apresentacao_oral;
	private Float notas_trabalho_grupo;	
	

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

	public Float getNotas_apresentacao_oral() {
		return notas_apresentacao_oral;
	}

	public void setNotas_apresentacao_oral(Float notas_apresentacao_oral) {
		this.notas_apresentacao_oral = notas_apresentacao_oral;
	}

	public Float getNotas_trabalho_grupo() {
		return notas_trabalho_grupo;
	}

	public void setNotas_trabalho_grupo(Float notas_trabalho_grupo) {
		this.notas_trabalho_grupo = notas_trabalho_grupo;
	}
	
}
