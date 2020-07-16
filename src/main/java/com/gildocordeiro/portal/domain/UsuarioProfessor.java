package com.gildocordeiro.portal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UsuarioProfessor  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Float nota_aula_expositiva;
	private Float nota_aula_pratica;
	private Float nota_aula_EaD;
	private String email_contato;
	
	@OneToOne(mappedBy = "professor")
	private Usuario usuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
