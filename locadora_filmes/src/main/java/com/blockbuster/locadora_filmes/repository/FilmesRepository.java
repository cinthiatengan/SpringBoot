package com.blockbuster.locadora_filmes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blockbuster.locadora_filmes.model.Filmes;

@Repository
public interface FilmesRepository extends JpaRepository<Filmes, Long>{
	public List<Filmes> findAllByTituloContainingIgnoreCase(String titulo); 

}
