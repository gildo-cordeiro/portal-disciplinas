package com.gildocordeiro.portal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.gildocordeiro.portal.domain.enums.TipoSituacao;

@Entity
public class Historico extends Entidade{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer frequencia;
	private Float nota_minima;
	private Float media;
	private Integer situacao;
	
	@OneToMany
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;
	
	@OneToMany
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFrquencia() {
		return frequencia;
	}
	public void setFrquencia(Integer frquencia) {
		this.frequencia = frquencia;
	}
	public Float getNota_minima() {
		return nota_minima;
	}
	public void setNota_minima(Float nota_minima) {
		this.nota_minima = nota_minima;
	}
	public Float getMedia() {
		return media;
	}
	public void setMedia(Float media) {
		this.media = media;
	}
	public TipoSituacao getSituacao() {
		return TipoSituacao.toEnum(situacao);
	}
	public void setSituacao(TipoSituacao situacao) {
		this.situacao = situacao.getCodigo();
	}

	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
		Historico other = (Historico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
