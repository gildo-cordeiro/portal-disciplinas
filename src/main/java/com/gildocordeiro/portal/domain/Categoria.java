package com.gildocordeiro.portal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//Criar nova tabela
@Entity

//Necessario para comunicar com o banco
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;

	//Anotação de chave primaria e autoincrement
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer escrita;
	private Integer desenvolvimento_oral;
	private Integer resolucao_problemas;
	private Integer racicionio_logico;
	private Integer proatividade;
	private Integer trabalho_equipe;
	
	//Mapeamento banco de dados 1-1
	@OneToOne(mappedBy = "categoria")
	private Usuario usuario;
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}
	
	public Categoria(Integer id, Integer escrita, Integer desenvolvimento_oral, Integer resolucao_problemas,
			Integer racicionio_logico, Integer proatividade, Integer trabalho_equipe) {
		super();
		this.id = id;
		this.escrita = escrita;
		this.desenvolvimento_oral = desenvolvimento_oral;
		this.resolucao_problemas = resolucao_problemas;
		this.racicionio_logico = racicionio_logico;
		this.proatividade = proatividade;
		this.trabalho_equipe = trabalho_equipe;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEscrita() {
		return escrita;
	}
	public void setEscrita(Integer escrita) {
		this.escrita = escrita;
	}
	public Integer getDesenvolvimento_oral() {
		return desenvolvimento_oral;
	}
	public void setDesenvolvimento_oral(Integer desenvolvimento_oral) {
		this.desenvolvimento_oral = desenvolvimento_oral;
	}
	public Integer getResolucao_problemas() {
		return resolucao_problemas;
	}
	public void setResolucao_problemas(Integer resolucao_problemas) {
		this.resolucao_problemas = resolucao_problemas;
	}
	public Integer getRacicionio_logico() {
		return racicionio_logico;
	}
	public void setRacicionio_logico(Integer racicionio_logico) {
		this.racicionio_logico = racicionio_logico;
	}
	public Integer getProatividade() {
		return proatividade;
	}
	public void setProatividade(Integer proatividade) {
		this.proatividade = proatividade;
	}
	public Integer getTrabalho_equipe() {
		return trabalho_equipe;
	}
	public void setTrabalho_equipe(Integer trabalho_equipe) {
		this.trabalho_equipe = trabalho_equipe;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
