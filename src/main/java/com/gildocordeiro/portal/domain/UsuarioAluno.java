package com.gildocordeiro.portal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UsuarioAluno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Float notas_apresentacao_oral;
	private Float notas_trabalho_grupo;	
	
	@OneToOne(mappedBy = "aluno")
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
