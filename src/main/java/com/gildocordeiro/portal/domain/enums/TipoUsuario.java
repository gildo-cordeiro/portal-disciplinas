package com.gildocordeiro.portal.domain.enums;

public enum TipoUsuario {
	
	ADMINISTRADOR(1, "ADM"),
	PROFESSOR(2, "PROFESSOR"),
	ALUNO(3, "ALUNO");
	
	private int codigo;
	private String descricao;
	
	
	private TipoUsuario(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}


	public String getDescricao() {
		return descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public static Integer toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (TipoUsuario usuario : TipoUsuario.values()) {
			if (cod.equals(usuario.getCodigo())) {
				return usuario.codigo;
			}
		}
		throw new IllegalArgumentException("Id invalido: "+cod); 
	}
	
	public static String getDesc(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (TipoUsuario usuario : TipoUsuario.values()) {
			if (cod.equals(usuario.getCodigo())) {
				return usuario.getDescricao();
			}
		}
		throw new IllegalArgumentException("Descrição não encontrada"); 
	}

}
