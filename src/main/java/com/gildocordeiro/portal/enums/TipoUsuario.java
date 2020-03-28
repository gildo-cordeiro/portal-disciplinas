package com.gildocordeiro.portal.enums;

public enum TipoUsuario {
	
	ADMINISTRADOR(1, "ADM"),
	PROFESSOR(1, "Professor"),
	ALUNO(3, "Aluno");
	
	private int codigo;
	private String descricao;
	
	
	private TipoUsuario(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}


	public int getCodigo() {
		return codigo;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static TipoUsuario toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (TipoUsuario usuario : TipoUsuario.values()) {
			if (cod.equals(usuario.getCodigo())) {
				return usuario;
			}
		}
		throw new IllegalArgumentException("Id invalido: "+cod); 
	}

}
