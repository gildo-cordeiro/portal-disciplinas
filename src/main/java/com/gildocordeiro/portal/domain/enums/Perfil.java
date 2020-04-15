package com.gildocordeiro.portal.domain.enums;

import java.util.ArrayList;
import java.util.List;

public enum Perfil {
	
	ADMINISTRADOR(0, "ROLE_ADM"),
	PROFESSOR(1, "ROLE_PROFESSOR"),
	ALUNO(2, "ROLE_ALUNO");
	
	private static List<Perfil> perfis = new ArrayList<Perfil>(); 
	
	static {
		perfis.add(Perfil.ADMINISTRADOR);
		perfis.add(Perfil.ALUNO);
		perfis.add(Perfil.PROFESSOR);
	}
	
	private int codigo;
	private final String descricao;

	
	private Perfil(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public static List<Perfil> getAll(){
		return perfis;
	}

	public static Integer toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (Perfil usuario : Perfil.values()) {
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
		
		for (Perfil usuario : Perfil.values()) {
			if (cod.equals(usuario.getCodigo())) {
				return usuario.getDescricao();
			}
		}
		throw new IllegalArgumentException("Descrição não encontrada"); 
	}
	
	public static Perfil getPerfil(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (Perfil usuario : Perfil.values()) {
			if (cod.equals(usuario.getCodigo())) {
				return usuario;
			}
		}
		throw new IllegalArgumentException("Descrição não encontrada"); 
	}

}
