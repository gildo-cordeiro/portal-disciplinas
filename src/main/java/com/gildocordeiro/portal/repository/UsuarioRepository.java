package com.gildocordeiro.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gildocordeiro.portal.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query(value="select u from Usuario u where u.userName = ?1")
	public Optional<Usuario> findByUserName(String username);
	
	
	@Query(value="select u from Usuario u where u.email = ?1")
	public Optional<Usuario> findByEmail(String email);
	
	//s@Query(value="SELECT p.perfil FROM usuario_permissoes up WHERE u.email = ?1", nativeQuery = true)
	//public List<Perfil> findPermissoes(String email);

}
