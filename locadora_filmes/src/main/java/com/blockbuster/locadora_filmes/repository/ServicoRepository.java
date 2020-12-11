package com.blockbuster.locadora_filmes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blockbuster.locadora_filmes.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
	public List<Servico> findAllByDescricaoContainingIgnoreCase(String descricao);

}
