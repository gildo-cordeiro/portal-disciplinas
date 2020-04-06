package com.gildocordeiro.portal.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.gildocordeiro.portal.domain.enums.TipoUsuario;

@Entity
public class Usuario implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private Integer tipo;	
	private String nome;
	private String email;
	private String userName;
	private String senha;
	private boolean ativo;

	@OneToMany(mappedBy = "usuario")
	private List<Turma> turmas;
	
	@OneToMany(mappedBy = "usuario")
	private List<Multimidia> multimidias;

	@OneToMany(mappedBy = "usuario")
	private List<Historico> historicos;
	
	public List<Historico> getHistoricos() {
		return historicos;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_aluno")
	private UsuarioAluno aluno;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_professor")
	private UsuarioProfessor professor;

	public UsuarioAluno getAluno() {
		return aluno;
	}
	
	public void setAluno(UsuarioAluno aluno) {
		this.aluno = aluno;
	}

	public UsuarioProfessor getProfessor() {
		return professor;
	}

	public void setProfessor(UsuarioProfessor professor) {
		this.professor = professor;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}
	
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


	public Integer getTipo() {
		return TipoUsuario.toEnum(tipo);
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo.getCodigo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
