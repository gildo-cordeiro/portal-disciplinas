package com.gildocordeiro.portal.enums;

public enum TipoSituacao {
	APROVADO(1, "Aprovado"),
	REPROVADO(2, "Reprovado");
	
	private int codigo;
	private String descrica;
	
	
	private TipoSituacao(int codigo, String descrica) {
		this.codigo = codigo;
		this.descrica = descrica;
	}


	public int getCodigo() {
		return codigo;
	}


	public String getDescrica() {
		return descrica;
	};
	
	public static TipoSituacao toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (TipoSituacao situacao : TipoSituacao.values()) {
			if (cod.equals(situacao.getCodigo())) {
				return situacao;
			}
		}
		throw new IllegalArgumentException("Id invalido: "+cod); 
	}

}
