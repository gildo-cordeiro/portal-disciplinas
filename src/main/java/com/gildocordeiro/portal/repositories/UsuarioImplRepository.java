package com.gildocordeiro.portal.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gildocordeiro.portal.domain.Usuario;

public class UsuarioImplRepository extends EntidadeImplRepository<Usuario> implements UsuarioRepository{

	@Autowired
	public UsuarioImplRepository(JpaRepository<Usuario, Integer> manager, Class<Usuario> tClass) {
		super(manager, tClass);
	}
}
