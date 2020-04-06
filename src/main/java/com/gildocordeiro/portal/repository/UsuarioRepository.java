package com.gildocordeiro.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gildocordeiro.portal.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("select u from Usuario u where u.email = ?1")
	public Optional<Usuario> findByEmail(String email);

}
