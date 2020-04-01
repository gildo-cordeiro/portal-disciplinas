package com.gildocordeiro.portal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Turma implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	private Float nota_aula_expositiva;
	private Float nota_aula_pratica;
	private Float nota_aula_EaD;
	
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;
	
	@ManyToOne
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;
	
	public Turma() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
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
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
