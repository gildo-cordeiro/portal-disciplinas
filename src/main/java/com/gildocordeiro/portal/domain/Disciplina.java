package com.gildocordeiro.portal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Disciplina implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, nullable = false)
	private String codigo;	
	private String nome;
	private String descricao;

	public Disciplina() {
		// TODO Auto-generated constructor stub
	}
	
	public Disciplina(String codigo, String nome, String descricao, Multimidia multimidia) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.multimidias.add(multimidia);
	}
	
	
	@OneToMany(mappedBy = "disciplina")
	private List<Historico> historicos;
	
	@OneToMany(mappedBy = "disciplina")
	private List<Turma> turmas;
	
	@OneToMany(mappedBy = "disciplina")
	private List<Multimidia> multimidias = new ArrayList<Multimidia>();
	
	
	public List<Multimidia> getMultimidias() {
		return multimidias;
	}

	public void setMultimidias(List<Multimidia> multimidias) {
		this.multimidias = multimidias;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
