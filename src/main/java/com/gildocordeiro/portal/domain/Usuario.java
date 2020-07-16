package com.gildocordeiro.portal.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.gildocordeiro.portal.domain.enums.Perfil;

@Entity
public class Usuario implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private String nome;
	@Column(unique = true, nullable = false)
	private String email;
	private String userName;
	private String senha;
	private boolean ativo;	
	private String path_image;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	private Set<Perfil> perfis = new HashSet<Perfil>();

	@OneToMany(mappedBy = "usuario")
	private List<Turma> turmas;

	@OneToMany(mappedBy = "usuario")
	private List<Historico> historicos;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_aluno")
	private UsuarioAluno aluno;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_professor")
	private UsuarioProfessor professor;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario")
	private Categoria categoria;
	
	@ManyToMany(mappedBy = "professores")
	private Set<Disciplina> disciplina;
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String email, String userName, String senha, boolean ativo,
			Perfil perfis, String path_image, UsuarioProfessor user_prof, UsuarioAluno user_aluno) {
		this.nome = nome;
		this.email = email;
		this.userName = userName;
		this.senha = senha;
		this.ativo = ativo;
		this.perfis.add(perfis);
		this.path_image = path_image;
		this.professor = user_prof;
		this.aluno = user_aluno;
	}
	
	public Set<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Set<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}


	public List<Historico> getHistoricos() {
		return historicos;
	}
	
	public UsuarioAluno getAluno() {
		return aluno;
	}
	public Set<Perfil> getPerfis() {
		return perfis;
	}
	
	public void addPerfil(Integer perfil) {
		perfis.add(Perfil.getPerfil(perfil));
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
	public String getPath_image() {
		return path_image;
	}

	public void setPath_image(String path_image) {
		this.path_image = path_image;
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
