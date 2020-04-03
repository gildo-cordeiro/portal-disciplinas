package com.gildocordeiro.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gildocordeiro.portal.domain.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina,Integer> {

}
