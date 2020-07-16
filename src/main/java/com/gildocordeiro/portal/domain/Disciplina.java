package com.gildocordeiro.portal.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, nullable = false)
	private String codigo;
	private String nome;
	private String descricao;
	private Integer semestre;

	@OneToMany(mappedBy = "disciplina")
	private List<Historico> historicos;

	@OneToMany(mappedBy = "disciplina")
	private List<Turma> turmas;

	@ManyToMany
	@JoinTable(name = "disciplina_professor", joinColumns = @JoinColumn(name = "userprof_id"), inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
	private Set<Usuario> professores;

	public Disciplina() {
		// TODO Auto-generated constructor stub
	}

	public Disciplina(String codigo, String nome, String descricao, Integer semestre, Set<Usuario> lista) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.semestre = semestre;
		this.professores = lista;
	}
	
	public Set<Usuario> getProfessores() {
		return professores;
	}

	public void setProfessores(Set<Usuario> professores) {
		this.professores.addAll(professores);
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

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

}
