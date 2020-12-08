package org.escola.diretoria.repository;

import java.util.List;
import org.escola.diretoria.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{
	public List<Turma> findAllByTurmaContainingIgnoreCase(String turma);
}
