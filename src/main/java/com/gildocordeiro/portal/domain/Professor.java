package com.gildocordeiro.portal.domain;

import javax.persistence.Entity;

@Entity
public class Professor extends Usuario{
	private static final long serialVersionUID = 1L;

	private String nome;
	private String email;
	private Float nota_aula_expositiva;
	private Float nota_aula_pratica;
	private Float nota_aula_EaD;
	private String email_contato;
	
	

	
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

	public Float getNota_aula_expositiva() {
		return nota_aula_expositiva;
	}

	public void setNota_aula_expositiva(Float nota_aula_expositiva) {
		this.nota_aula_expositiva = nota_aula_expositiva;
	}

	public Float getNota_aula_pratica() {
		return nota_aula_pratica;
	}

	public void setNota_aula_pratica(Float nota_aula_pratica) {
		this.nota_aula_pratica = nota_aula_pratica;
	}

	public Float getNota_aula_EaD() {
		return nota_aula_EaD;
	}

	public void setNota_aula_EaD(Float nota_aula_EaD) {
		this.nota_aula_EaD = nota_aula_EaD;
	}

	public String getEmail_contato() {
		return email_contato;
	}

	public void setEmail_contato(String email_contato) {
		this.email_contato = email_contato;
	}

}
