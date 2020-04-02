package com.gildocordeiro.portal.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Float notas_apresentacao_oral;
	private Float notas_trabalho_grupo;	
	
	@OneToMany(mappedBy = "aluno")
	private List<Historico> historicos;
	
	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
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
