package com.gildocordeiro.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gildocordeiro.portal.domain.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina,Integer> {
	
	@Query(value="select d from Disciplina d")
	public List<Disciplina> findAll();

}
