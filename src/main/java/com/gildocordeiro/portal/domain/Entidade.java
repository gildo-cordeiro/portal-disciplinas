package com.gildocordeiro.portal.domain;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Entidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Entidade() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract Integer getId();
	
	public abstract void setId(Integer id);
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	

}
