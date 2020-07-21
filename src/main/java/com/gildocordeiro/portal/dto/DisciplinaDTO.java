package com.gildocordeiro.portal.dto;

public class DisciplinaDTO {

	private String codigo;
	private String nome;
	private String turma;
	private String descricao;
	private Integer semestre;
	private Integer user;//porfessor da disciplina
	private String pathImage;
	
	
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public Integer getUser() {
		return user;
	}
	public void setUser(Integer user) {
		this.user = user;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPathImage() {
		return pathImage;
	}
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
}
