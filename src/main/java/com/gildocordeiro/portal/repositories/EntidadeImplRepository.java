package com.gildocordeiro.portal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gildocordeiro.portal.domain.Entidade;

public class EntidadeImplRepository<T extends Entidade> implements EntidadeRepository<T>{
	
	protected JpaRepository<T, Integer> manager;
	protected Class<T> tClass;
	
	public EntidadeImplRepository(JpaRepository<T, Integer> manager, Class<T> tClass){
		this.manager = manager;
		this.tClass = tClass;
	}

	@Override
	public T salvar(T entidade) {
		this.manager.save(entidade);
		return entidade;
	}

	@Override
	public T buscar(T entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(T entidade) {
		manager.delete(entidade);		
	}

	@Override
	public List<T> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
