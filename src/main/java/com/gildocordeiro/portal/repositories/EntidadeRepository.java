package com.gildocordeiro.portal.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gildocordeiro.portal.domain.Entidade;


@Repository
public abstract interface EntidadeRepository<T extends Entidade>{

	T salvar(T entidade);
	T buscar(T entidade);
	void remover(T entidade);
	List<T> listar();

}
