package com.gildocordeiro.portal.domain.enums;

public enum TipoMultimidia {
	
	VIDEO(1, "VIDEO"),
	AUDIO(2, "MUSICA"),
	PDF(3, "PDF"),
	IMG(4,"IMAGEM");
	
	private int codigo;
	private String descricao;
	
	private TipoMultimidia(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static TipoMultimidia toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (TipoMultimidia multimidia : TipoMultimidia.values()) {
			if (cod.equals(multimidia.getCodigo())) {
				return multimidia;
			}
		}
		throw new IllegalArgumentException("Id invalido: "+cod); 
	}

}
